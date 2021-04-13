// Xor Sum Pairwise
// find sum of all xor pairsum 
import java.util.ArrayList;
import java.util.Arrays;

class XorSumPair
{
    XorSumPair(ArrayList<Integer> A)
    {
        long sum = 0;
        long n = A.size();
        for(int i=0; i<=30; i++)
        {
            long setBit=0;
            for(int j:A)
            {
                if(((j>>i)&1)==1)
                    setBit++;
            }
            sum+=(setBit*(n-setBit)*(1<<i));
        }
        System.out.print(sum*2);
    }
    public static void main(String[] args) {
        new XorSumPair(new ArrayList<Integer>(Arrays.asList(3,5,6,8,2)));
    }
}
/**
 * ex: 3,5,6,8,2
 * we will find contribution for each number at their respective bit position rather than traditional brute force;
    ith bit: 3 2 1 0  (2^i)
          3: 0 0 1 1
          5: 0 1 0 1
          6: 0 1 1 0
          8: 1 0 0 0
          2: 0 0 1 0

          0th pos count set bit and unset bit

          set = 2 and unset = 3

          logic :     xor    1^1 = 0^0 = 0 (no use)
                             1^0 = 0^1 = 1 (usefull)

                             now 2 set bit of 0th pos will make pairs with 3 unsetbit of 0th pos.

                             2*3 = 6 pairs but there are repeating pair so total conbution C0 = 6*2 = 12
                            
                              pos                    3           2           1          0
                             (setbit)*(unsetbit)   1*4          2*3         3*2         2*3
                             contribution           8           12          12          12        X2(repeating)
                             sumXor              8*(2^3)      12*(2^2)    12*(2^1)    12*(2^0)    =  148
 * 
 */