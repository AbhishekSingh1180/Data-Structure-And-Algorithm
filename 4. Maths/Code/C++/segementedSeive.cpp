// Given a,b & (b-a)<=10^5.
// find all primes 1<=(a,b)<=10^10.
#include<bits/stdc++.h>
using namespace std;
vector<bool> prime(1000001,true);
vector<int> primes;
void seive()
{
	prime[0] = prime[1] = false;
	for(int i=2; i*i<=1000000; i++)
		if(prime[i])
			for(int j=i*i; j<=1000000; j+=i)
				prime[j] = false;
	for(int i=0; i<=1000000; i++)
		if(prime[i])	
			primes.push_back(i);
}
void segmentedSieve(const vector<vector<long> > &Q)
{
	int query = Q.size();
	for(int i=0; i<query; i++)
	{
		long a = Q[i][0];
		long b = Q[i][1];
		vector<bool> segment(b-a+1,true);
		for(int j=0; j<primes.size(); j++)
		{
			long x = primes[j];
			if((x*x)>b) // check upto sqrt(b) primes
				break;
			long start = (a/x)*x;  // same as a - a%x + x means first multiple of x 
			// ex:  a:100  x:3     (100/3)*3  33*3 = 99 
			if(a==x or start==0) 
			{
				start=2*x; // a:2 x:2 both prime but start should be a+x = 4 
			}
			else if(start<a) 
				start+=x; // above 100 3 case start 99 but idealy should be 102 hence 99+3 start+x = 102
			for(; start<=b; start+=x)
				segment[start-a]=false;  // mark all multiple false

			//if(a==0) segment[0]=segment[1]=false; when a=0 but not given in question 
			if(a==1)
				segment[0]=false; // a:1 special case 1/2 * 2 = 0 start = 0  start = 2*2 = 4 segment[4-a] i.e s[4-1] s[3] i.e 4 marked false but
				// s[0] never get false i.e s[0] = false 
		}
		cout<<"Primes between ["<<a<<","<<b<<"] :   ";
		for(long j=0; j<segment.size(); j++)
			if(segment[j]) 
				cout<<a+j<<" ";
		cout<<endl;
	}
}
int main()
{
	seive();
	vector<vector<long> > Q{{7,49},{5,60},{2,11},{1,30}};
	segmentedSieve(Q);
}