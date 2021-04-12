import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

//Print the greycode upto N digit binary Number
class greyCodeIterative
{
    static void greyCodeDecimal(ArrayList<Integer> greyDecimal , int N)
    {
        while((greyDecimal.size())<(1<<N))
        {
            int shift = (int)(Math.log(greyDecimal.size())/Math.log(2));
            for(int i=greyDecimal.size()-1; i>=0; i--)
            {
                greyDecimal.add((1<<shift)+greyDecimal.get(i));
            }
        }
    }
    static void greyCodeBinary(ArrayList<String> greyBinary , int N)
    {
        while((greyBinary.size())<(1<<N))
        {
            for(int i=greyBinary.size()-1; i>=0; i--)
            {
                greyBinary.add('1'+greyBinary.get(i));
                greyBinary.set(i,'0' + greyBinary.get(i));
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> greyBinary = new ArrayList<String>(Arrays.asList("0","1"));
        ArrayList<Integer> greyDecimal = new ArrayList<Integer>(Arrays.asList(0,1));
        greyCodeBinary(greyBinary,3);
        greyCodeDecimal(greyDecimal,3);
        for(String i:greyBinary) System.out.println(i);
        for(int i:greyDecimal) System.out.println(i);
    
    }
} 

/**
 * LOGIC - GREY CODE
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
