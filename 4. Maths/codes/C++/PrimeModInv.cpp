// Prime Modulo Inverse
// Problem Description

// Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.

// A-1 mod B is also known as modular multiplicative inverse of A under modulo B.



// Problem Constraints
// 1 <= A <= 109
// 1<= B <= 109
// B is a prime number



// Input Format
// First argument is an integer A.
// Second argument is an integer B.



// Output Format
// Return an integer denoting the modulor inverse



// Example Input
// Input 1:

//  A = 3
//  B = 5
// Input 2:

//  A = 6
//  B = 23


// Example Output
// Output 1:

//  2
// Output 2:

//  4


// Example Explanation
// Explanation 1:

//  Let's say A-1 mod B = X, then (A * X) % B = 1.
//  3 * 2 = 6, 6 % 5 = 1.
// Explanation 2:

//  Similarly, (6 * 4) % 23 = 1.
#include <iostream>
#define ll long long
using namespace std;
ll power(ll A, ll B, ll M)
{
    if(B==0) return 1;
    ll X = power(A,B/2,M);
    if(B%2==0) return (X%M*X%M)%M;
    else return (X%M*X%M*A%M)%M;
}
int invmod(int A, int B)
{
    return (int)power(A,B-2,B);
}
int main()
{
    cout<<invmod(3,5);
    return 0;
}
// fermat little theorem
// A^B-1==1mod(B)

// A^B-2===A^-1mod(B)

// 3^-1mod5 = 3^5-2 = 3^3mod5
