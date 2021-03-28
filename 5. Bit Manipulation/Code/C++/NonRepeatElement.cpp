// Single Number
// Problem Description

// Given an array of integers A, every element appears twice except for one. Find that single one.

// NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



// Problem Constraints
// 2 <= |A| <= 2000000

// 0 <= A[i] <= INTMAX



// Input Format
// First and only argument of input contains an integer array A.



// Output Format
// Return a single integer denoting the single element.



// Example Input
// Input 1:

//  A = [1, 2, 2, 3, 1]
// Input 2:

//  A = [1, 2, 2]


// Example Output
// Output 1:

//  3
// Output 2:

//  1


// Example Explanation
// Explanation 1:

// 3 occurs once.
// Explanation 2:

// 1 occurs once.
#include<iostream>
#include<vector>
using namespace std;
int NonRepeatElement(const vector<int> &A)
{
    int x = 0; // x^0 = x  doesn't matter
    for(int i:A) x^=i; //1^1^2 = 2   associative hence all repeating element will become 0 and only unique will come with xor
    return x;
}
int main() 
{
    vector<int> A{1,1,2,2,3,4,4,5,5};
    cout<<NonRepeatElement(A);
}
