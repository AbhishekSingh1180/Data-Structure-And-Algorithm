/**Factor Game
Problem Description

Write a program to input T numbers(N) from user and print all the factors of the given numbers.



Problem Constraints
1 <= T <= 1000

1 <= N <= 100000000



Input Format
First line is T which means number of test cases.

Each next T lines contain an integer N.



Output Format
T lines each containing space separated integers in sorted form representing all the factors of the input integer.



Example Input
Input 1:

2
6
10
Input 2:

2
7
18


Example Output
Output 1:

1 2 3 6
1 2 5 10
Output 2:

1 7
1 2 3 6 9 18


Example Explanation
Explanation 1:

6 is divisible by 1,2,3,6.
10 is divisible by 1,2,5,10.
Explanation 2:

7 is divisible by only 1,7.
18 is divisible by 1,2,3,6,9,18.**/
#include<bits/stdc++.h>
using namespace std;
void factors(vector<int> &factor,const int &n)
{
    vector<int> other;
    for(int i=1;i*i<=n;i++)
    {
        if(n%i==0)
        {
            if(i==(n/i)) factor.push_back(i);
            else
            {
                factor.push_back(i);
                other.push_back(n/i);
            }
        }
    }
    for(int i=factor.size()-1;i>=0;i--) factor.push_back(other[i]); 
}
void printFactors(const int &n)
{
    vector<int> factor;
    factors(factor,n);
    for(auto i:factor) cout<<i<<" ";
}
int main()
{
    int t;   cin>>t;
    while(t--)
    {
        int n;  cin>>n;
        printFactors(n);
        cout<<endl;
    }
    return 0;
}