/**
Inversion count in an array
Problem Description

Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.
 **/


// MODIFIED MERGE SORT

#include<bits/stdc++.h>
#define mod 1000000007
using namespace std;
int invMCnt(vector<int> &A,vector<int> &Aux,int start,int mid,int end)
{
    int i = start, j = mid+1, k = start;
    int invcnt = 0;
    while(i<=mid && j<=end)
    {
        if(A[i]<=A[j]) Aux[k++]=A[i++];
        else
        {
            Aux[k++]=A[j++];
            invcnt+=(mid+1-i)%mod;
        }
    }
    while(i<=mid) Aux[k++]=A[i++];
    while(j<=end) Aux[k++]=A[j++];
    for(int i=start; i<=end; i++) A[i] = Aux[i];
    return invcnt;

}
int invMsCnt(vector<int> &A,vector<int> &Aux,int start,int end)
{
    int inversion = 0;
    if(start<end)
    {
        int mid = (start+end)/2;
        inversion+=(invMsCnt(A,Aux,start,mid))%mod;
        inversion+=(invMsCnt(A,Aux,mid+1,end))%mod;
        inversion+=(invMCnt(A,Aux,start,mid,end))%mod;
    }
    return inversion;
}
int inversionCount(vector<int> &A)
{
    int n = A.size();
    vector<int> Aux(n,0);
    int cnt = invMsCnt(A,Aux,0,n-1);
    return cnt;
}
int main()
{
    vector<int> arr{1,6,2,4,3};
    cout<<inversionCount(arr)<<endl;
}