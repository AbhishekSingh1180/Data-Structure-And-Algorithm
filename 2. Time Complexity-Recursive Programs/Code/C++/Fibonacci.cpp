#include<bits/stdc++.h>
using namespace std;
int fib(int x)
{
    if(x<=1) return x;
    return fib(x-1)+fib(x-2);
}
int main()
{
    for(int i=1;i<=13;i++) cout<<i<<" : "<<fib(i)<<endl;
}