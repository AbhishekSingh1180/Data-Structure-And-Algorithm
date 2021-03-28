#include<iostream>
#include<vector>
using namespace std;
int NonRepeatElement(const vector<int> &A)
{
    int x = 0; // x^0 = x  doesn't matter
    for(int i:A) x^=i; //1^1^2 = 2   associative hence all repeating element will become 0 and only unique will come with xor
    return x;
}
int main() 
{
    vector<int> A{1,1,2,2,3,4,4,5,5};
    cout<<NonRepeatElement(A);
}
