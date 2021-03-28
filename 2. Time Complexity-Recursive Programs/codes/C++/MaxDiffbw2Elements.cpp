/**
 * Maximum difference between two elements
Problem Description

Given an array A of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.



Problem Constraints
2 <= length of A <= 106

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum difference between any two elements.



Example Input
Input 1:

 A = [2, 3, 10, 6, 4, 8, 1]
Input 2:

 A = [7, 9, 5, 6, 3, 2]


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 The maximum difference is between 10 and 2.
Explanation 2:

 The maximum difference is between 9 and 7.
 **/
#include<bits/stdc++.h>
using namespace std;
int maxmindiff(vector<int> &A)
{
    int minElnt = A[0];
    int maxDiff = INT_MIN;
    for(int i=1; i<A.size(); i++)
    {
        maxDiff = max((A[i]-minElnt),maxDiff);
        minElnt = min(A[i],minElnt);
    }
    return maxDiff;
}
int main()
{
    vector<int> A{1,1};
    cout<<maxmindiff(A);
}