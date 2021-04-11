// Xor Sum Pairwise
// find sum of all xor pairsum 
#include <iostream>
#include <vector>
#define L long long
using namespace std;
int xorPairSum(vector<int> &A) 
{
    L sum = 0;
    L n = A.size();
    for(int i=0; i<=30; i++)
    {
        L setBit = 0;
        for(auto j:A) (((j>>i)&1)==1)?(++setBit):0;
        sum+=(setBit*(n-setBit)*(1<<i));
    }
    return (int)(sum*2);
}
int main()
{
    vector<int> A{3,5,6,8,2};
    cout<<xorPairSum(A);
}

/**
 * ex: 3,5,6,8,2
 * we will find contribution for each number at their respective bit position rather than traditional brute force;
    ith bit: 3 2 1 0  (2^i)
          3: 0 0 1 1
          5: 0 1 0 1
          6: 0 1 1 0
          8: 1 0 0 0
          2: 0 0 1 0

          0th pos count set bit and unset bit

          set = 2 and unset = 3

          logic :     xor    1^1 = 0^0 = 0 (no use)
                             1^0 = 0^1 = 1 (usefull)

                             now 2 set bit of 0th pos will make pairs with 3 unsetbit of 0th pos.

                             2*3 = 6 pairs but there are repeating pair so total conbution C0 = 6*2 = 12
                            
                              pos                    3           2           1          0
                             (setbit)*(unsetbit)   1*4          2*3         3*2         2*3
                             contribution           8           12          12          12        X2(repeating)
                             sumXor              8*(2^3)      12*(2^2)    12*(2^1)    12*(2^0)    =  148
 * 
 */