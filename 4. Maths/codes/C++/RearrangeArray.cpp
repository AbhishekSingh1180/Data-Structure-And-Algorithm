// Rearrange Array
// Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

// Example:

// Input : [1, 0]
// Return : [0, 1]
//  Lets say N = size of the array. Then, following holds true :
// All elements in the array are in the range [0, N-1]
// N * N does not overflow for a signed integer
#include<iostream>
#include<vector>
using namespace std;
void arrange(vector<int> &A) 
{
    int N = A.size();
    for(int i=0; i<N; i++) A[i]*=N;
    for(int i=0; i<N; i++) A[i] = A[i] + A[A[i]/N]/N;
}
void print(vector<int> &A ,int N)
{
    for(auto i:A) cout<<i%N<<" ";
}
int main()
{
    vector<int> A{4,0,2,1,3};
    arrange(A);
    print(A,A.size());
}