// Implement Power Function
// Implement pow(x, n) % d.

// In other words, given x, n and d,

// find (xn % d)

// Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

// Input : x = 2, n = 3, d = 3
// Output : 2
// 2^3 % 3 = 8 % 3 = 2.
#include<bits/stdc++.h>
#define mod 1000000007
#define ll long long int
using namespace std;
int power(int a, int b, int c)
{
    if(a==0) return 0;
    if(b==0) return 1;
    ll x = power(a,b/2,c);
    if(b%2==0) return (int)(x%c*x%c)%c;
    else return (int)(x%c*x%c*(a+c)%c)%c;
}
int main()
{
    cout<<power(-1,1,20);
}