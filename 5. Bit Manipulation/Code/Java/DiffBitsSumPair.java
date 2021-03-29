import java.util.ArrayList;
import java.util.Arrays;

class DiffBitsSumPair
{
    static Boolean checkbit(int N, int i) { return ((N>>i)&1)==1;}
    DiffBitsSumPair(ArrayList<Integer> A)
    {
        long sum = 0;
        long M = 1000000007;
        for(int i=0; i<32; i++)
        {
            long set=0, unset=0;
            for(int j:A) 
                if(checkbit(j,i)) ++set;
                else ++unset;
            sum+=(set*unset)%M;
        }
        System.out.print((sum*2)%M);
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,3,5));
        new DiffBitsSumPair(A);
    }
}