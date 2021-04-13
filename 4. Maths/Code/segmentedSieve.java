import java.util.ArrayList;
import java.util.Arrays;

class segmentedSieve
{
    static int MAX = 1000000;
    static Boolean[] prime = new Boolean[MAX+1];
    static ArrayList<Integer> Primes = new ArrayList<Integer>();
    static void seive()
    {
        Arrays.fill(prime,Boolean.TRUE);
        prime[0] = prime[1] = false;
        for(int i=2; i*i<=MAX; i++)
            if(prime[i])
                for(int j=i*i; j<=MAX; j+=i)
                    prime[j] = false;
        for(int i=2; i<=MAX; i++)
            if(prime[i]) Primes.add(i);
    }
    segmentedSieve(ArrayList<ArrayList<Integer>> Q)
    {
        int query = Q.size();
        for(int i=0; i<query; i++)
        {
            long A = Q.get(i).get(0);
            long B = Q.get(i).get(1);
            Boolean[] segment = new Boolean[(int)(B-A+1)];
            Arrays.fill(segment, Boolean.TRUE);
            for(int j=0; j<Primes.size(); j++)
            {
                long X = Primes.get(j);
                if((X*X)>B) 
                    break;
                long start = (A/X)*X;
                if(start==0 || start==X)
                    start=2*X;
                else if(start<A)
                    start+=X;
                for(; start<=B; start+=X)
                    segment[(int)(start-A)]=false;
                if(A==1)
                    segment[0]=false;
            }
            System.out.print("Primes B/W ["+A+","+B+"] : ");
            for(int j=0; j<(B-A+1); j++)
                if(segment[j])
                    System.out.print((j+A)+" ");
            System.out.print("\n");      
        }

    }
    public static void main(String[] args) {
        seive();
        ArrayList<ArrayList<Integer>> Q = new ArrayList<ArrayList<Integer>>();
        Q.add(0,new ArrayList<Integer>(Arrays.asList(1,50)));
        Q.add(1,new ArrayList<Integer>(Arrays.asList(2,50)));
        Q.add(2,new ArrayList<Integer>(Arrays.asList(3,50)));
        new segmentedSieve(Q);
        
    }
}