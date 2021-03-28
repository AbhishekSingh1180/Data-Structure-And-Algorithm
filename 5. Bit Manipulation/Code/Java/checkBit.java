class checkBit
{
    static Boolean bit(int N, int i)
    {
        return ((N>>i)&1)==1; //bring Nth ith bit to 1 and check if its set or unset;
        //return (N&(1<<i))==(1<<i); // reverse put 1st bit to ith ans check.
    }
    public static void main(String[] args) 
    {
        System.out.print(bit(42,2)+" "+bit(14,2));
    }
}