class DivisorGame {
    static int max(int A, int B) {return Math.max(A,B);}
    static int min(int A, int B) {return Math.min(A,B);}
    static int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    static int divisors(int A, int B, int C) {
        return A/(B*C/gcd(max(B,C),min(B,C)));
    }
    public static void main(String[] args) {
        System.out.print(divisors(12,2,3));
    }
    
}
