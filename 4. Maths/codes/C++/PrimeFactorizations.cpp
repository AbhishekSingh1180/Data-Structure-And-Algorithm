#include<bits/stdc++.h>
#define MAX 1000000
using namespace std;
int spf[MAX+1];
void seive()
{
	for(int i=0; i<=MAX; i++) spf[i]=i;
	for(int i=2; i*i<=MAX; i++)
	{
		if(spf[i]==i) // prime
		{
			for(int j=i*i; j<=MAX; j+=i)
			{
				if(spf[j]==j) //old
					spf[j]=i; //new
			}
		}
	}
}
void PrimeFactors(int N)
{
	seive();
	while(N!=1)
	{
		cout<<spf[N]<<" ";
		N/=spf[N];
	}
	
}
int main()
{
	int N = 12246;
	PrimeFactors(N);
}

