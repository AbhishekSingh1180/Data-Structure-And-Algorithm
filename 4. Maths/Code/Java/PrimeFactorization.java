class PrimeFactorization {
    int MAX = 1000000;
    int[] SPF = new int[MAX+1];
    PrimeFactorization()
    {
        for(int i=0; i<=MAX; i++) SPF[i] = i;
        for(int i=2; i*i<=MAX; i++) 
        {
            if(SPF[i]==i) //prime
            {
                for(int j=i*i; j<=MAX; j+=i) 
                {   
                    if(SPF[j]==j) //old
                        SPF[j]=i;
                }
            }
        }
    }
    void PrimeFactors(int N)
    {
        while(N!=1)
        {
            System.out.print(SPF[N]+" ");
            N/=SPF[N];
        }
    }
    public static void main(String[] args) {
        PrimeFactorization Prime = new PrimeFactorization();
        Prime.PrimeFactors(12246); 
    }
}
