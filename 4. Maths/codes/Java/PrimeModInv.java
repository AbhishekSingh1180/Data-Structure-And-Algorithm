class PrimeModInv 
{
    public static long power(long A, long B, long M)
    {
        if(B==0) return 1;
        long X = power(A,B/2,M);
        if(B%2==0) return (X%M*X%M)%M;
        else return (X%M*X%M*A%M)%M;
    }
    public static int invmod(int A, int B)
    {
        return (int)power(A,B-2,B);
    }   
    public static void main(String[] args)
    {
        System.out.print(invmod(6,23));
    }
}
