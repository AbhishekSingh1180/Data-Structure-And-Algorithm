import java.util.ArrayList;
import java.util.Collections;

class gcdpairs
{   
    static int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    static void push(int X, ArrayList<Integer> orginal, int[] freqA)
    {
        int N = orginal.size();
        for(int i=0; i<N; i++) freqA[gcd(X,orginal.get(i))]-=2;
        freqA[X]--;
        orginal.add(X);
    }
    static ArrayList<Integer> originalPairs(ArrayList<Integer> A)
    {
        int N = A.size();
        Collections.sort(A);

        int[] freqA = new int[A.get(N-1)+1];
        for(int i=0; i<N; i++) freqA[A.get(i)]++;

        ArrayList<Integer> orginal = new ArrayList<Integer>();

        for(int i=N-1; i>=0; i--) if(freqA[A.get(i)]>0) push(A.get(i),orginal,freqA);
        return orginal;
    }
    static void print(ArrayList<Integer> A)
    {
        for(int i=A.size()-1; i>=0; i--) System.out.print(A.get(i)+" ");
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2); A.add(2); A.add(2); A.add(2); A.add(8); A.add(2); A.add(2); A.add(2); A.add(10);
        ArrayList<Integer> B = originalPairs(A);
        print(B);
    }
}