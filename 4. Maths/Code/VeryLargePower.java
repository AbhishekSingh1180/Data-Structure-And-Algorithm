class VeryLargePower {
    long M = 1000000007;
    long powerMod(long A, long B)
    {
        if(B==0) return 1;
        long X = powerMod(A,B/2);
        if(B%2==0) return (X%M*X%M)%M;
        else return (X%M*X%M*A%M)%M;
    }
    public int solve(int A, int B) 
    {
        long R = 1;
        for(long i = 1; i <= B; i++) R = (R*i)%(M-1);
        int ans = (int)powerMod(A,R);
        return ans;
    }
    public static void main(String[] args)
    {
        VeryLargePower X = new VeryLargePower();
        System.out.print(X.solve(35, 68));
    }
}
// A^B!%M   M=1000000007
// fermat litte theorem
// A^(p-1) == 1modp
// A^(B-1) = 1modB
// A^B!= A^(M-1) + A^(M-1) + .... + A^(M-1) + A^R(remainder)
// A^B!= A^(M-1)*N + A^R
// A^(M-1)*N = 1 acc. to fermat sir = 1modM = 1
// A^B!%M = A^R%M
// B! = (M-1)N + R
// R = B!%(M-1)
