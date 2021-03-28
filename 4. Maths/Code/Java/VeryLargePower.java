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
