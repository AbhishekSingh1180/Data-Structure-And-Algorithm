/**
Array Rotations
Problem Description

Power of the array is the count of indices between 0 and N - 2, where arr[i] >= arr[i+1].

Given an array A of size N, return an array of N integers where the value at K-th index denotes the power of the array after the K-th cyclic shift towards the left.

NOTE: If there is an array, [A[0], A[1], ... A[n-1]], then its k-th cyclic shift towards left will be [A[k], A[k+1], ... A[n-1], A[0], A[1], ... A[k-1]].



Problem Constraints
1 <= N <= 105
0 <= A[i] <= 105



Input Format
First and only argument is an array of integers A.



Output Format
Return an array of integers denoting the answer.



Example Input
Input 1:

 A = [19, 4, 4]


Example Output
Output 1:

 [2, 1, 1]


Example Explanation
Explanation 1:

 Given array A = [19, 4, 4], Power(A) = 1 (19 >= 4) + 1 (4 >= 4) = 2
 1st cyclic shift, A => [4, 4, 19], Power(A) = 1 (4 >= 4) + 0 (4 < 19) = 1 
 2nd cyclic shift, A => [4, 19, 4], Power(A) = 0 (4 < 19) + 1 (19 >= 4) = 1
 So, the ans is [2, 1, 1].
 **/

/**
 * 19 4 4     2
 * 4 4 19     1
 * 4 19 4     1 
 **/

#include<bits/stdc++.h>
using namespace std;
vector<int> power(vector<int> &A) 
{
    int n = A.size(), k = 0;
    vector<int> B;
    
    for(int i = 0; i < n-1; i++) if(A[i]>=A[i+1]) k++;
    B.push_back(k);

    for(int i = 0; i < n-1; i++)
    {
        k=(A[i]>=A[i+1])?k-1:k;
        int p = (i-1)<0?n-1:i-1;
        k=(A[p]>=A[i])?k+1:k;
        B.push_back(k);
    }
    return B;
}
int main()
{
    vector<int> A{19,4,4};
    vector<int> ans;
    ans = power(A);
    for(auto i:ans) cout<<i<<" ";
}