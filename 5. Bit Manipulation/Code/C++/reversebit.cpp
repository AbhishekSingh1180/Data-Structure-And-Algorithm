#include <iostream>
#define U unsigned int
using namespace std;
U checkbit(U N, U pos) { return (N>>pos)&1;}
U setbit(U N, U pos) { return N|(1<<pos);}
U unsetbit(U N, U pos) { return N&(~(1<<pos));}
U reversebit(U N)
{
    U Msb = sizeof(N)*8-1 , Lsb = 0;  //msb bits 31
    while(Msb>Lsb) //till msb pos is greater then lsb
    {
        U Mbit = checkbit(N,Msb) , Lbit = checkbit(N,Lsb); //check msb and lsb 
        if(Mbit!=Lbit) // we will only swap if msb and lsb bcz if same no swap is required.
        {
            N = Mbit?setbit(N,Lsb):unsetbit(N,Lsb); // if msb is 1 then unset it or viceversa
            N = Lbit?setbit(N,Msb):unsetbit(N,Msb); // if lsb is 1 then unset it or viceversa
        }
        Msb--;Lsb++; //inc lsb and dcr msb
    }
    return N;
}
int main()
{
    unsigned int N = 3;
    cout<<reversebit(N);
}