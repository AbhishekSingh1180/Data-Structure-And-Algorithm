/**Rain Water Trapped
Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.
**/
#include<bits/stdc++.h>
using namespace std;

int trap(const vector<int> &A)
{
    int N = A.size();
    vector<int> rMax(N);
    rMax[N-1] = A[N-1];

    for(int i=N-2; i>=0; i--) rMax[i] = max(rMax[i+1],A[i]);

    int WaterTrap = 0;
    int lMax = A[0];

    for(int i= 0; i < N-1; i++)
    {
        lMax = max(lMax,A[i]);
        WaterTrap+= (min(lMax,rMax[i])-A[i]);
    }
    return WaterTrap;
}
int main()
{
    vector<int> A{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    cout<<trap(A);
    return 0;
}
