// Different Bits Sum Pairwise
// Problem Description

// We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
// For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

// You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.



// Problem Constraints
// 1 <= N <= 105

// 1 <= A[i] <= 231 - 1



// Input Format
// First and only argument of input contains a single integer array A.



// Output Format
// Return a single integer denoting the sum.



// Example Input
// Input 1:

//  A = [1, 3, 5]
// Input 2:

//  A = [2, 3]


// Example Output
// Ouptut 1:

//  8
// Output 2:

//  2


// Example Explanation
// Explanation 1:

//  f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) 
//  = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
// Explanation 2:

//  f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
#include <iostream>
#include <vector>
#define M 1000000007
#define L long long
using namespace std;
bool checkbit(int N, int i)
{
    return ((N>>i)&1)==1;
}
int cntBits(vector<int> &A) 
{
    L sum = 0;
    for(int i=0; i<32; i++)
    {
        L set = 0;
        L unset = 0;
        for(auto j:A) checkbit(j,i)?(++set)%M:(++unset)%M;
        sum+=(set*unset)%M;
    }
    return (int)((sum*2)%M);
}
int main()
{
    vector<int> A{1,3,5};
    cout<<cntBits(A);
}

/**
 * ex: 1 3 5
    ith bit: 3 2 1 0  (2^i)
          1: 0 0 0 1
          3: 0 0 1 1
          5: 0 1 0 1

          lets take pair 1 and 3   0001 and 0011  diff bit at pos 1 only f(1,3) = 1
          lets take f(3,5) diff at 1 and 2 pos f(3,5) = 2

          instead of comparing element wise lets compare bitwise

          if we look for position 1 we have (1,3) (3,5)  where pos 1  setbit num = {3} while unsetbit num = {1,5} 
          to get valid pair we need to have ith bit of two numbe diff
          3(1th bit) 1 will make pair with 1(1th bit) 0 and 5(1th bit) 0
          i.e (3,1) (3,5) has one set bit making pair with 2 unset bit also (1,3) (3,5)

          similarily (5,1) and (5,3) 5 setbit will make pair with unset bit of 1,3 and also (1,5) (3,5) also valid 
          this is combination    ex:   A{1}  B{0,0}   pairs possible {(1,0),(1,0),(0,1),(0,1)} = 4 
          no of ways = [ n(A)*n(B)*2 ]( 2 because (1,3) (3,1) are different)

          so count setbit and unsetbit at each ith bit position contribution at ith pos is set*unset and
          add all the position contribution.
 * 
 */