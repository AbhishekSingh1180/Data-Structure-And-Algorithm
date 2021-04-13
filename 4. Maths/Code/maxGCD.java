import java.util.ArrayList;
class maxGCD {

    int max(int A, int B) {return Math.max(A,B);}
    int min(int A, int B) {return Math.min(A,B);}

    int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    int MaxGcd(ArrayList<Integer> A)
    {
        int N = A.size();
        int[] PreGCD = new int[N];
        int[] SufGCD = new int[N];
        PreGCD[0] = A.get(0);
        SufGCD[N-1] = A.get(N-1);
        for(int i=1; i<N; i++) PreGCD[i] = gcd(max(PreGCD[i-1],A.get(i)),min(PreGCD[i-1],A.get(i))); //prefix gcd
        for(int i=N-2; i>=0; i--) SufGCD[i] = gcd(max(SufGCD[i+1],A.get(i)),min(SufGCD[i+1],A.get(i))); //suffix gcd
        int maxgcd = 1;
        for(int i=0; i<N; i++)
        {
            if(i==0) maxgcd = max(maxgcd,SufGCD[i+1]); // 0th element
            else if(i==(N-1)) maxgcd = max(maxgcd,PreGCD[i-1]); // Nth element
            else maxgcd = max(maxgcd,gcd(PreGCD[i-1],SufGCD[i+1]));
        }
        return maxgcd;
    }
    public static void main(String[] args) 
    {
        maxGCD Num = new maxGCD();
        ArrayList<Integer> A = new ArrayList<Integer>(3);
        A.add(12); A.add(15); A.add(18);
        System.out.print(Num.MaxGcd(A));
    }
}
