#include<bits/stdc++.h>
using namespace std;
void merge(vector<int> &A,int start,int mid,int end)
{
    vector<int> temp((end-start+1),0);
    int i = start, j = mid+1,k=0;
    while(i<=mid && j<=end)
    {
        if(A[i]<=A[j]) temp[k++]=A[i++];
        else temp[k++]=A[j++];
    }
    while(i<=mid) temp[k++]=A[i++];
    while(j<=end) temp[k++]=A[j++];
    for(int i =start; i<=end; i++) A[i] = temp[i-start];
}
void mergesort(vector<int> &A,int start,int end)
{
    if(start<end)
    {
        int mid = (start+end)/2;
        mergesort(A,start,mid);
        mergesort(A,mid+1,end);
        merge(A,start,mid,end);
    }
}
int main()
{
    vector<int> A{6,3,8,9,1,2,4};
    int size = A.size();
    mergesort(A,0,size-1);
    for(auto i:A) cout<<i<<" ";
}