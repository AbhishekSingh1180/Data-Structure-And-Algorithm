// Rearrange Array
// Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

// Example:

// Input : [1, 0]
// Return : [0, 1]
//  Lets say N = size of the array. Then, following holds true :
// All elements in the array are in the range [0, N-1]
// N * N does not overflow for a signed integer
import java.util.ArrayList;
class RearrangeArray 
{
    static void arrange(ArrayList<Integer> A) 
    {
        int N = A.size();
        for(int i=0; i<N; i++) A.set(i,A.get(i)*N);
        for(int i=0; i<N; i++) A.set(i,(A.get(i) + A.get(A.get(i)/N)/N));
    }
    static void print(ArrayList<Integer> A ,int N)
    {
        for(int i:A) System.out.print(i%N+" ");
    }  
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(4); A.add(0); A.add(2); A.add(1); A.add(3);
        arrange(A);
        print(A,A.size());
    }  
}
/**
 * A: 4 0 2 1 3
 * N= 5
 * A*N: 20 0 10 5 15
 * A/N gives old value
 * Z=(A*N+A[A[i]/n]): 23 4 12 5 16
 * Z%N gives new value
 * Z%N = 3 4 2 0 1
 * 
 *  
 */
