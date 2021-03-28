#include<bits/stdc++.h>
using namespace std;
int power(int b ,int p)
{
    if(p==0) return 1;
    int val = power(b,p/2);
    if((p&1)==1) return b*val*val;
    else return val*val;
}
int main()
{
    cout<<power(6,2);
}