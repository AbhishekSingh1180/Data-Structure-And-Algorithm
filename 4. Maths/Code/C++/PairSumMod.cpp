// Pair Sum divisible by M
// Problem Description

// Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

// Since the answer may be large, return the answer modulo (109 + 7).



// Problem Constraints
// 1 <= length of the array <= 100000
// 1 <= A[i] <= 109
// 1 <= B <= 106



// Input Format
// The first argument given is the integer array A.
// The second argument given is the integer B.



// Output Format
// Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).



// Example Input
// Input 1:

//  A = [1, 2, 3, 4, 5]
//  B = 2
// Input 2:

//  A = [5, 17, 100, 11]
//  B = 28


// Example Output
// Output 1:

//  4
// Output 2:

//  1


// Example Explanation
// Explanation 1:

//  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
//  So total 4 pairs.
#include <bits/stdc++.h>
#define M 1000000007
#define ll long long
using namespace std;
int pairsumM(vector<int> &A, int B) {
    
    vector<int> P(B,0);
    for(auto i:A) P[i%B]++;
    
    int start = 1 , end = B-1;
    ll X = P[0], Y;
    Y = X-1;
    ll cnt = (X*Y/2)%M;
    
    while(start<=end)
    {
        ll S = P[start];
        ll T = S-1;
        if(start==end)
        {
            cnt=(cnt+(S*T/2)%M)%M;
            break;
        } 
        cnt=(cnt+(P[start]*P[end])%M)%M;
        start++;
        end--;
    }
    return (int)cnt;
}
int main()
{
    vector<int> pair{5, 17, 100, 11};
    int B = 28;
    cout<<pairsumM(pair,B);
}

// A[]: 1 2 3 4 5
// B: 2
// A%B : 1 0 1 0 1
// B[] : 2(0) 3(1)

// 2!/1!*2! + 3!/2!*1! if P[i]==P[j] i==j comninations
// else p[i]*p[j]