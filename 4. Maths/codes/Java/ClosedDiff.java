import java.util.ArrayList;
class ClosedDiff
{
    static int max(int A, int B){return Math.max(A,B);}
    static int min(int A, int B){return Math.min(A,B);}
    static int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    static int allDiffArr(ArrayList<Integer> A)
    {   
        int n = A.size();
        if(n==1) return 1;
        int Ag = A.get(0);
        int maxElm = A.get(0);
        Boolean zero = false;
        for(int i:A)
        {
            if(i==0) zero = true;
            if(i>maxElm) maxElm = i;
            Ag = gcd(max(Ag,i),min(Ag,i));
        }
        return zero?(maxElm/Ag)+1:maxElm/Ag;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2); A.add(4); A.add(6); A.add(7);
        System.out.print(allDiffArr(A));
    }
}