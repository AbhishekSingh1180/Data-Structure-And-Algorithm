class OneDcount {
    static int Dcount(int N)
    {
        int count = 0;
        int current = 0, before = 0, after = 0;
        int i = 1;
        while((N/i)!=0)
        {
            current = (N/i)%10;
            before = (N/(i*10));
            after = N - (N/i)*i;

            if (current > 1) count+=((before+1)*i);
            else if (current == 0) count+=(before*i);
            else if (current == 1) count+=(before*i)+(after+1);
            i*=10;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.print(Dcount(123));
    }
}

