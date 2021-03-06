//Given N distinct element generate all permutations:
import java.util.ArrayList;
import java.util.Arrays;
public class nPermutation {
    ArrayList<ArrayList<Integer>> per = new ArrayList<ArrayList<Integer>>();
    nPermutation(ArrayList<Integer> arr)
    { 
        Integer[] tempArr = new Integer[arr.size()];
        Arrays.fill(tempArr, -1);

        //ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(tempArr));
        printPermutation1(0, arr); // no sorting needed
        //printPermutation2(0, arr,temp); // sort needed
        for(ArrayList<Integer> i : per)
        {
            for(int j : i)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    void swap(ArrayList<Integer> arr, int i ,int j)
    {   
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    //swap method - already sorted
    void printPermutation1(int start, ArrayList<Integer> arr)
    {
        if(start==arr.size())
        {
            per.add(new ArrayList<Integer>(arr));
            return;
        }
        for(int i = start; i<arr.size(); i++)
        {
            swap(arr, start, i); // swap(0,0) swap(0,1) swap(0,2) ..... 
            printPermutation1(start+1, arr); // move forward
            swap(arr, start, i); // revert decision
        }
    }
    //fill method - sort needed
    void printPermutation2(int start, ArrayList<Integer> arr, ArrayList<Integer> temp)
    {
        if(start==arr.size())
        {
            per.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i<arr.size(); i++)
        {
            if(temp.get(i)==-1)
            {
                temp.set(i,arr.get(start));
                printPermutation2(start+1, arr, temp);
                temp.set(i, -1);
            }
        }
    }
    public static void main(String[] args) {
        new nPermutation(new ArrayList<Integer>(Arrays.asList(4,7,8)));
    }
}
/**
 * To generate permutation we will use concept of swapping and fixing
 * 4 7 8
 * 4 8 7
 * 7 4 8
 * 7 8 4
 * 8 4 7
 * 8 7 4
 * 
 /**
 * 
 * 
 *       Use recursion tree
 * 
 *       [] - fixed 
 *       rest = permute further
 *                                             INDEX : 0 1 2
 *                                                     4 7 8                                                    line 1
 *                                                       | 
 *                            .--------------------------.--------------------------.   
 *                            |                          |                          |             
 *                         [4] 7 8                    [7] 4 8                    [8] 7 4                        line 2
 *                        SWAP(0,0)                  SWAP(0,1)                  SWAP(0,2)
 *                            |                          |                          |         
 *                    .---------------.          .---------------.          .--------------.       
 *                 [4 7] 8         [4 8] 7    [7 4] 8         [7 8] 4    [8 7] 4        [8 4] 7                 line 3
 *                SWAP(1,1)       SWAP(1,2)  SWAP(1,1)       SWAP(1,2)  SWAP(1,1)      SWAP(1,2)
 * 
 *                 note from    ABC (Line 1)  TO    [7] 4 8  (line 2)  we swap
 *                 and now for    ABC (Line 1)  TO    [8] 7 4  (line 2)  we need original ABC but we swap to BAC 
 *                 BAC  swap to  CAB [wrong]   thats why there are two swap to revert changes BAC revert ABC swap CBA  
 */ 
