#include <iostream>
using namespace std;
bool checkbit(int N, int i)
{
    //return ((N>>i)&1)==1; //bring Nth ith bit to 1 and check if its set or unset;
    return (N&(1<<i))==(1<<i); // reverse put 1st bit to ith ans check.
}

int setbit(int N, int i)
{
    return N|(1<<i); //bring 1 to ith bit and use OR operation to set; 
}

int flipbit(int N, int i)
{
    return N^(1<<i);    //0^1 = 1   1^1 = 0 xor flip the bit.
}

int unsetbit(int N, int i)
{
    if(checkbit(N,i)) return flipbit(N,i); //if ith bit is set then flip otherwise return N;
    return N; // already unset
}

int main()
{
    // i:    8 7 6 5 4 3 2 1 0 - (2^i)
    // 42 -  0 0 0 1 0 1 0 1 0 - (bits)

    cout<<checkbit(42,2)<<" "<<checkbit(42,3)<<endl; //false true
    cout<<setbit(42,0)<<" "<<unsetbit(42,1)<<endl; //43 40
    cout<<flipbit(42,1)<<endl; // 40
}