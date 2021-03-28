class reversebit
{
    static long checkbit(long N, long pos) { return ((N>>pos)&1L);}
    static long setbit(long N, long pos) { return N|(1L<<pos);}
    static long unsetbit(long N, long pos) { return N&(~(1L<<pos));}
    static long reverse(long N)
    {
        long Msb = 31, Lsb = 0;
        while(Msb>Lsb)
        {
            long Mbit = checkbit(N,Msb), Lbit = checkbit(N,Lsb);
            if(Mbit!=Lbit)
            {
                N = (Mbit==1L)?setbit(N,Lsb):unsetbit(N,Lsb);
                N = (Lbit==1L)?setbit(N,Msb):unsetbit(N,Msb);
            }
            Msb--;Lsb++;
        }
        return N;
    }   
    public static void main(String[] args) {
        long  N = 3;
        System.out.print(reverse(N));
    }
}