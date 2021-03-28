import java.util.Arrays;
import java.util.ArrayList;

class SingleNum3 
{
    Boolean checkbit(int N, int i){ return ((N>>i)&1)==1; }
    ArrayList<Integer> twounique(final ArrayList<Integer> A)
    {
        int x = 0;
        for(int i:A) x^=i; // xor of array
        int pos=0, P=0, Q=0; //element A and B
        for(int i=0; i<32; i++)
            if(checkbit(x,i)) // check first lsb set bit
            {
                pos = i;
                break;
            }
        for(int i:A)
            if(checkbit(i,pos))
                P^=i;
            else Q^=i; // separting xor for set and unset ith element

        return new ArrayList<Integer>(Arrays.asList(Math.min(P,Q),Math.max(P,Q))); //sorted order
    }
    public static void main(String[] args) {
        SingleNum3 X = new SingleNum3();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,2,2,3,3,4,5,5,6,6,8));
        for(Integer i: X.twounique(A)) System.out.print(i+" ");
    }
    
}
