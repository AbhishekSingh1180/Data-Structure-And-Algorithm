#include <iostream>
using namespace std;
int trailingZeroes(int A) {
    int zeros = 0;
    for(int i=5; i<=A; i*=5) zeros+=A/i;
    return zeros;
}
int main()
{
    cout<<trailingZeroes(100);
}
// Trailing 0s in n! = Count of 5s in prime factors of n!
//                   = floor(n/5) + floor(n/25) + floor(n/125) + ....