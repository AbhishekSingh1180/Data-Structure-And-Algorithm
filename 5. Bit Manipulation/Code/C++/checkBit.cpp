#include <iostream>
using namespace std;
bool checkbit(int N, int i)
{
    //return ((N>>i)&1)==1; //bring Nth ith bit to 1 and check if its set or unset;
    return (N&(1<<i))==(1<<i); // reverse put 1st bit to ith ans check.
}
int main()
{
    cout<<checkbit(14,2)<<" "<<checkbit(42,2);
}