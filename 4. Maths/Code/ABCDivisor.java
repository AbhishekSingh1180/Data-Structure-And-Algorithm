class ABCDivisor {
    static int gcd(int A,int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    static int solve(int A, int B, int C) {
        int x = Math.max(B,C);
        int y = Math.min(B,C);
    
    // int count = 0;
    // for(int i=x; i<=A ; i+=x) if(i%y==0) count++;
    
    // return count;
        return A/((B*C)/gcd(x,y));
    }
    public static void main(String[] args)
    {
        System.out.print(solve(12,3,2));
    }

}