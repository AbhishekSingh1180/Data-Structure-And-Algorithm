// ALL GCD PAIR
// Problem Description

// Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

// Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



// Problem Constraints
// 1 <= N <= 10000

// 1 <= A[i] <= 109



// Input Format
// The first and only argument given is the integer array A.



// Output Format
// Find and return the original numbers which are used to calculate the GCD array in any order.



// Example Input
// Input 1:

//  A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
// Input 2:

//  A = [5, 5, 5, 15]


// Example Output
// Output 1:

//  [2, 8, 10]
// Output 2:

//  [5, 15]


// Example Explanation
// Explanation 1:

//  Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
//  2 is the gcd between 2 and 8, 2 and 10.
//  8 and 10 are the gcds pair with itself.
//  Therefore, [2, 8, 10] is the original array.
// Explanation 2:

//  Initially, array A = [5, 5, 5, 15].
//  5 is the gcd between 5 and 15.
//  15 is the gcds pair with itself.
//  Therefore, [5, 15] is the original array.

#include <bits/stdc++.h>
using namespace std;
int gcd(int A, int B)
{
    if(B==0) return A;
    return gcd(B,A%B);
}
void push(int X, vector<int> &orginal, vector<int> &freqA)
{
    int N = orginal.size();
    for(int i=0; i<N; i++)
    {
        freqA[gcd(X,orginal[i])]-=2; // remove elements from freq array whose gcd are from biggest element and rest.
    }
    freqA[X]--; // reduce biggest element by 1
    orginal.push_back(X); // push biggest element to original array
}
vector<int> orginalPair(vector<int> &A)
{
    int N = A.size();
    sort(A.begin(),A.end()); // sort

    vector<int> freqA(A[N-1]+1, 0);
    for(int i=0; i<N; i++) freqA[A[i]]++; // freq array

    vector<int> orignal; //original array

    for(int i=N-1; i>=0; i--)
    {
        if(freqA[A[i]]>0) push(A[i],orignal,freqA);
    }
    return orignal;
}
void print(vector<int> &A)
{
    for(int i=A.size()-1; i>=0; i--) cout<<A[i]<<" ";
}
int main()
{
    vector<int> A{2, 2, 2, 2, 8, 2, 2, 2, 10};
    vector<int> B = orginalPair(A);
    print(B);
}