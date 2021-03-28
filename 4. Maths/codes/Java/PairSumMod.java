import java.util.ArrayList;
class PairSumMod
{

    static final int mod = 1000000007;
    int solve(ArrayList<Integer> A, int B)
    {
        int[] MA = new int[B];
        for(int i=0; i<A.size(); i++) MA[A.get(i)%B]++;
        //for(int i:MA) System.out.println(i);
        long Z = MA[0];
        long count = ((Z*(Z-1))/2)%mod;
        int start=1, end=B-1;
        while(start<=end)
        {
            long X = MA[start];
            long Y = MA[end];
            if(start==end)
            {
                count = (count + (X*(X-1))/2)%mod;
                break;
            }
            count = (count + (X*Y))%mod;
            start++;
            end--;
        } 
        return (int)count;
    }
    public static void main(String[] args)
    {
        PairSumMod P = new PairSumMod();
        ArrayList<Integer> A = new ArrayList<Integer>(5);
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        int B = 2;
        int ans = P.solve(A,B);
        System.out.print(ans);
        
    }
}