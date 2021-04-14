import java.util.ArrayList;
import java.util.Arrays;

class uniquePermutation
{
    private ArrayList<ArrayList<Integer>> ans;
    private void swap(ArrayList<Integer> A, int start, int end)
    {
        int temp = A.get(start);
        A.set(start,A.get(end));
        A.set(end,temp);
    }
    private void permutation( ArrayList<Integer> A, int start, int end)
    {
        if(start==end) ans.add(new ArrayList<Integer>(A)); //providing here a new instance of A so that it has no relation to previous A;
        else
        {
            for(int i=start; i<=end; i++)
            {
                swap(A,start,i);
                permutation(A,start+1,end);
                swap(A,start,i);
            }
        }
    }
    ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A)
    {
        ans = new ArrayList<ArrayList<Integer>>();
        permutation(A,0,A.size()-1);
        return ans;
    }
    public static void main(String[] args) {
        uniquePermutation num = new uniquePermutation();
        ArrayList<ArrayList<Integer>> P = num.permute(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
        for(int i=0; i<P.size(); i++)
        {
            for(int j=0; j<P.get(i).size(); j++)
            {
                System.out.print(P.get(i).get(j)+" ");
            }
            System.out.println();
        }        
    }
}