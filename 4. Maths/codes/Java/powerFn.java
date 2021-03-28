class powerFn
{
    static int power(int a, int b, int c)
    {
        if(a==0) return 0;
        if(b==0) return 1;
        long x = power(a,b/2,c);
        if(b%2==0) return (int)((x%c*x%c)%c);
        return (int)((x%c*x%c*(a+c)%c)%c);
    }
    public static void main(String[] args)
    {
        System.out.println(power(-1,2,20));
        System.out.print(power(-1,1,20));
    }
}