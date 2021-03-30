// Interesting Array
// Problem Description

// You have an array A with N elements. We have 2 types of operation available on this array :
// We can split a element B into 2 elements C and D such that B = C + D.
// We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
// You have to determine whether it is possible to make array A containing only 1 element i.e. 0 after several splits and/or merge?



// Problem Constraints
// 1 <= N <= 100000

// 1 <= A[i] <= 106



// Input Format
// The first argument is an integer array A of size N.



// Output Format
// Return "Yes" if it is possible otherwise return "No".



// Example Input
// Input 1:

//  A = [9, 17]
// Input 2:

//  A = [1]


// Example Output
// Output 1:

//  Yes
// Output 2:

//  No


// Example Explanation
// Explanation 1:

//  Following is one possible sequence of operations -  
//  1) Merge i.e 9 XOR 17 = 24  
//  2) Split 24 into two parts each of size 12  
//  3) Merge i.e 12 XOR 12 = 0  
//  As there is only 1 element i.e 0. So it is possible.
// Explanation 2:

//  There is no possible way to make it 0.
#include <iostream>
#include <string>
#include <vector>
using namespace std;
string solve(vector<int> A) 
{
    int oddcnt = 0;
    for(auto i:A) if((i&1)==1) oddcnt++;
    return ((oddcnt&1)==1)?"No":"Yes";
}
int main()
{
    cout<<solve(vector<int> {9, 17})<<endl;
    cout<<solve(vector<int> {1});
}
/**
 * In this problem we can merge(A^B) and split(A+B)
    but since our goal is to find if array can be made 0
    so only way is to keep merging elements
    now if we look A^A=0 
    and this only possible when final element is even  2A = A + A;
    so we only need to worry about odd elements bcz even elements will ultimaty become zero
    Odd+odd = even 
    so we need to find if we have an odd odd number 
    i.e count no. of odd if count is even they ultimately become 0
    else odd count will become 1 
 * 
 */