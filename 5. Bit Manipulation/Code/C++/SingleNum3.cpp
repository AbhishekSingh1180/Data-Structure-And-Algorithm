// Single Number III
// Problem Description

// Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// Note: Output array must be sorted.



// Problem Constraints
// 2 <= |A| <= 100000
// 1 <= A[i] <= 109



// Input Format
// First argument is an array of interger of size N.



// Output Format
// Return an array of two integers that appear only once.



// Example Input
// Input 1:

// A = [1, 2, 3, 1, 2, 4]
// Input 2:

// A = [1, 2]


// Example Output
// Output 1:

// [3, 4]
// Output 2:

// [1, 2]


// Example Explanation
// Explanation 1:

//  3 and 4 appear only once.
// Explanation 2:

//  1 and 2 appear only once.
#include <iostream>
#include <vector>
using namespace std;
bool checkbit(int N, int i)
{
    return ((N>>i)&1)==1;
}
vector<int> twounique(const vector<int> &A)
{
    int x = 0;
    for(int i:A) x^=i; // xor of array
    int pos, P=0, Q=0; //element A and B
    for(int i=0; i<32; i++)
        if(checkbit(x,i)) // check first lsb set bit
        {
            pos = i;
            break;
        }
    for(int i:A) checkbit(i,pos)?P^=i:Q^=i; // separting xor for set and unset ith element

    return vector<int> {min(P,Q),max(P,Q)}; //sorted order
}
int main()
{
    vector<int> A{1,1,2,2,3,3,4,5,5,6,6,8};
    for(int i:twounique(A)) cout<<i<<" ";
}
/** logic
    when we take xor of array we get final value as xor of two unique element
    we need to separate these element and then take xor
    Ex: 1 1 2 2 3 3 4 5 5 6 6 8
           xor = 4^8
           4: 0100
           8: 1000
           ^: 1100 in this case first lsb set is 2nd bit lets separate other
           now we now when bits are different xor has set bit
           we will check which first lsb bit is set
           then separate both the xor elements i.e 4 and 8 bcz they both have different bit for that position

           set 2nd bit: 4 5 5 6 6  xor(set elements) = 4
           unset 2nd bit: 1 1 2 2 3 3 8 xor(unset element) = 8
 **/