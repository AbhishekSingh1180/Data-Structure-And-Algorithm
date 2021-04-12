//Given N discs print the path movement of all discs.
#include <iostream>
using namespace std;
void towerOfHanoi(char S, char T, char D, int n)    // S: source  T: temp   D: Destination  n: no. of dics
{
    if(n==0) return;
    towerOfHanoi(S,D,T,n-1);      // n-1 discs from source to temp
    cout<<n<<" : "<<S<<" --> "<<D<<endl;  // nth disc from source to destination
    towerOfHanoi(T,S,D,n-1); // n-1 discs from temp to destination
}
int main()
{
    int n;
    cin>>n; //no. of discs
    towerOfHanoi('A','B','C',3);
}
