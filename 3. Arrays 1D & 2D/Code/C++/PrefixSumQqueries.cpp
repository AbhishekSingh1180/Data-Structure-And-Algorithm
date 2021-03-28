#include<bits/stdc++.h>
using namespace std;

int sumQ(vector<int> &prefixA,int start,int end)
{
    return (start==0)?prefixA[end]:(prefixA[end]-prefixA[start-1]);
}

int main()
{
    vector<int> A{-3,6,2,4,5,2,8,-9,3,1};
    vector<vector<int> > Q{{1,3}, {2,6}, {0,2}, {4,8}, {7,7}};
    for(int i = 1; i < A.size(); i++) A[i]+=A[i-1];

    for(int i = 0; i < Q.size(); i++)
        cout<<sumQ(A,Q[i][0],Q[i][1])<<endl;
}
//T(max(Q,N)):S(N)