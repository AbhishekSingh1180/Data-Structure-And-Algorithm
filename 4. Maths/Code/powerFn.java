// Implement Power Function
// Implement pow(x, n) % d.

// In other words, given x, n and d,

// find (xn % d)

// Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

// Input : x = 2, n = 3, d = 3
// Output : 2
// 2^3 % 3 = 8 % 3 = 2.

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
/**
 * 5^4 =  5*5*5*5 or power(5,4) or 2*power(5,2);
 * 5^5 = 5*5*5*5*5 or power(5,5) or 2*power(5,2)*power(5,1);
 */