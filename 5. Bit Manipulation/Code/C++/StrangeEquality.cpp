// Strange Equality
// Problem Description

// Given an integer A.
// Two numbers X and Y are defined as follows:

// X is the greatest number smaller than A such that XOR sum of X and A is the same as the sum of X and A.
// Y is the smallest number greater than A such that XOR sum of Y and A is the same as the sum of Y and A.
// Find and return the XOR of X and Y.

// NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

// NOTE 2: Your code will be run against a maximum of 100000 Test Cases.



// Problem Constraints
// 1 <= A <= 109



// Input Format
// First and only argument is an integer A.



// Output Format
// Return an integer denoting the XOR of X and Y.



// Example Input
// A = 5


// Example Output
// 10


// Example Explanation
// The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int flipbit(int N, int i) { return N^(1<<i); }
int solve(int A)
{
    int T = A;
    int MSB = (int)(log2(T));
    for(int i=0; i<=MSB; i++) T=flipbit(T,i);
    return T^(1<<(MSB+1));
}
int main()
{
    cout<<solve(5)<<endl;
    cout<<solve(7);
}
/**
 * ex: 5 
    5: 0101
    MSB = 2

    to get number less than 5 i.e X we need to change all unset bits to set to get addition.
     0101
    +0010
     0111 = 7 
     flip all bit upto msb
    similar
    to get number greater than 5 i.e X we need to change msb+1 bit

     0101
    +1000
     1101 = 13
     2^8 = 10
 * 
 */