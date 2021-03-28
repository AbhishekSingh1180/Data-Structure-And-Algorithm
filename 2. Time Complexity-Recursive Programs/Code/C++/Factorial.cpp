#include<bits/stdc++.h>
using namespace std;
int factorial(int x)
{
    if(x==0) return 1;
    return x*factorial(x-1);
}
int main()
{
    cout<<factorial(6);
}