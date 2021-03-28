// Count of divisors
// Problem Description

// Given an array of integers A, find and return the count of divisors of each element of the array.

// NOTE: Order of the resultant array should be same as the input array.



// Problem Constraints
// 1 <= length of the array <= 100000
// 1 <= A[i] <= 106



// Input Format
// The only argument given is the integer array A.



// Output Format
// Return the count of divisors of each element of the array in the form of an array.



// Example Input
// Input 1:

//  A = [2, 3, 4, 5]
// Input 2:

//  A = [8, 9, 10]


// Example Output
// Output 1:

//  [2, 2, 3, 2]
// Output 1:

//  [4, 3, 4]


// Example Explanation
// Explanation 1:

//  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
//  So the count will be [2, 2, 3, 2].
// Explanation 2:
//  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
//  So the count will be [4, 3, 4]
#include <iostream>
#include <vector>
#define MAX 1000000
using namespace std;
int spf[MAX+1] = {0};
void SOE()
{
    for(int i=1;i<=MAX;i++) spf[i]=i;
    for(int i=2;i*i<=MAX;i++)
    {
        if(spf[i]==i)//prime check
        {
            for(int j=i*i;j<=MAX;j+=i)
            {
                if(spf[j]==j) //old value
                {
                    spf[j]=i; //new value
                }
            }
        }
    }
}
vector<int> divcnt(vector<int> &A) 
{
    SOE();
    vector<int> div;
    for(auto i:A)
    {
        int ans = 1;
        int temp = i;
        while(temp!=1)
        {
            int cnt = 1;
            int x =spf[temp];
            while(temp!=1 and temp%x==0)
            {
                cnt++;
                temp/=x;
            }
            ans*=cnt;
        }
        div.push_back(ans);
    }
    return div;
}
int main()
{
    vector<int> A{2, 3, 4, 5};
    vector<int> B;
    B = divcnt(A);
    for(auto i:B) cout<<i<<" ";
}
/**
 *  36 = 2*2*3*3 prime factors
 *  2- 2 a
 *  3- 2 b
 * number of divsor = (a+1)(b+1)
 *                  = (3)(3)
 *                  = 9
 * 36 =  1 2 3 4 6 9 12 18 36 = 9 divisors.
 *    
 */
