#include <iostream>
#define U unsigned int
using namespace std;
U checkbit(U N, U pos) { return (N>>pos)&1;}
U setbit(U N, U pos) { return N|(1<<pos);}
U unsetbit(U N, U pos) { return N&(~(1<<pos));}
U reversebit(U N)
{
    U Msb = sizeof(N)*8-1 , Lsb = 0;
    while(Msb>Lsb)
    {
        U Mbit = checkbit(N,Msb) , Lbit = checkbit(N,Lsb);
        if(Mbit!=Lbit)
        {
            N = Mbit?setbit(N,Lsb):unsetbit(N,Lsb);
            N = Lbit?setbit(N,Msb):unsetbit(N,Msb);
        }
        Msb--;Lsb++;
    }
    return N;
}
int main()
{
    unsigned int N = 3;
    cout<<reversebit(N);
}