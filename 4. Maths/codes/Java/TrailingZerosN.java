class TrailingZerosN 
{
    int TrailingZeros(int N)
    {
        int count = 0; 
        for(int i=5; i<=N; i*=5) count+=N/i;
        return count;
    }
    public static void main(String[] args)
    {
        TrailingZerosN A = new TrailingZerosN();
        System.out.print(A.TrailingZeros(100));
    }  
}
