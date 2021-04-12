import java.util.ArrayList;
import java.util.Arrays;

//Print the graycode upto N digit binary Number
class grayCodeIterative
{
    static void grayCodeDecimal(ArrayList<Integer> grayDecimal , int N)
    {
        while((grayDecimal.size())<(1<<N))
        {
            int sumNewBit = grayDecimal.size(); // new bit add will at (n-1) pos ex. n=3  pos =2  2^2 = 4 size() of previous array;
            for(int i=grayDecimal.size()-1; i>=0; i--)
            {
                grayDecimal.add(sumNewBit+grayDecimal.get(i));
            }
        }
    }
    static void grayCodeBinary(ArrayList<String> grayBinary , int N)
    {
        while((grayBinary.size())<(1<<N))
        {
            for(int i=grayBinary.size()-1; i>=0; i--)
            {
                grayBinary.add('1'+grayBinary.get(i));
                grayBinary.set(i,'0' + grayBinary.get(i));
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> grayBinary = new ArrayList<String>(Arrays.asList("0","1"));
        ArrayList<Integer> grayDecimal = new ArrayList<Integer>(Arrays.asList(0,1));
        grayCodeBinary(grayBinary,3);
        grayCodeDecimal(grayDecimal,3);
        for(String i:grayBinary) System.out.println(i);
        for(int i:grayDecimal) System.out.println(i);
    
    }
} 

/**
 * LOGIC - gray CODE
 * 
 * N=1     0: [0]
 *         1: [1]
 * 
 * N=2     0: 0|[0]    this bracket part is same as N=1 
 *         1: 0|[1]    with 0 in front
 *         -------
 *         3: 1|[1]    this bracket part is same as N=1 in reverse 
 *         2: 1|[0]    with 1 in front
 * 
 * N=3     0: 0|[00]
 *         1: 0|[01]   this bracket part is same as N=2
 *         3: 0|[11]   with 0 in front
 *         2: 0|[10]
 *         ---------
 *         6: 1|[10]
 *         7: 1|[11]   this bracket part is same as N=w in reverse
 *         5: 1|[01]   with 1 in front
 *         4: 1|[00]
 * 
 * this part repeats for all N and hence recursion or iterative method can be used
 * 
 * Iterative method;
 * 
 * 1.binary representaion
 * 
 * vector {'0','1'}
 * N=1 done
 * 
 * 
 * reverse iterate from back
 * 
 * iterating from back {'1','0'}
 * 
 * push('1'+'1') and '1'+'0'   {0,01,11}
 *  push('1'+'0') and '0'+'0'   {00,01,11,10}
 * 
 * vector {'00','01','11','10'}
 * N=2 done
 * 
 * similarly do for N=3
 * 
 * 2. decimal 
 *     for each number if n = 2  we add set bit at n-1 pos i.e (1<<(log2(n))) ex. n=2 1<<1 = 2   n=3  1<<2=4 
 *  vector {0,1}
 *  N=1 done
 * 
 * 
 *  reverse iterate from back
 * 
 *  iterating from back {1,0}
 * 
 *  push(pow(2,1)+1)   {0,1,3}   pow(2,1)  1<<1  = 2^1 = 2
 *  push(pow(2,0)+1)   {0,1,3,2}
 * 
 *  vector {0,1,3,2}
 *  N=2 done
 *  similarly do for N=3
 */
