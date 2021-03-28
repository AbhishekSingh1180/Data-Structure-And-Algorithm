import java.util.*;
class DivisorCount 
{
    static int max = 1000000;
    static int[] spf = new int[max+1];
    void SOE()
    {
        spf[0]=1;
        for(int i=1; i<=max; i++) spf[i]=i;
        for(int i=2; i*i<=max; i++)
            if(spf[i]==i)
                for(int j=i*i; j<=max; j+=i)
                    if(spf[j]==j) 
                        spf[j]=i;
    }
    ArrayList<Integer> Divisors(ArrayList<Integer> A) 
    {
        SOE();
        ArrayList<Integer> B = new ArrayList<Integer>(A.size());
        for(int i:A)
        {
            int temp = i;
            int ans = 1;
            while(temp!=1)
            {
                int cnt = 1;
                int x = spf[temp];
                while(temp!=1 && (temp%x)==0)
                {
                    cnt++;
                    temp=temp/x;
                }
                ans*=cnt;
            }
            B.add(ans);
        }
        return B;
    }
    void print(ArrayList<Integer> B) 
    {
        for(int i:B) System.out.print(i+" ");
    }
    public static void main(String[] args)
    {
        DivisorCount D1 = new DivisorCount();
        ArrayList<Integer> A = new ArrayList<Integer>(4);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        ArrayList<Integer> B = new ArrayList<Integer>(4);
        B = D1.Divisors(A);
        D1.print(B);
        
    }   
}
