//Print the graycode upto N digit binary Number
#include <iostream>
#include <vector>
#include <cmath>
#include <string>
using namespace std;
vector<int> grayCodeDecimal(int N)
{
    if(N==1) return vector<int> {0,1};
    vector<int> grayDecimal = grayCodeDecimal(N-1);
    while((grayDecimal.size())<(1<<N))
    {
        int sumNewBit = grayDecimal.size(); // new bit add will at (n-1) pos ex. n=3  pos =2  2^2 = 4 size() of previous array;
        for(int i=grayDecimal.size()-1; i>=0; i--)
        {
            grayDecimal.push_back(sumNewBit+grayDecimal[i]);
        }
    }
    return grayDecimal;
}
vector<string> grayCodeBinary(int N)
{
    if(N==1) return vector<string> {"0","1"};
    vector<string> grayBinary = grayCodeBinary(N-1);
    while((grayBinary.size())<(1<<N))
    {
        for(int i=grayBinary.size()-1; i>=0; i--)
        {
            grayBinary.push_back('1'+grayBinary[i]);
            grayBinary[i] = '0' + grayBinary[i];
        }
    }
    return grayBinary;
}
int main()
{
    for(string i:grayCodeBinary(3)) cout<<i<<endl;
    for(int i:grayCodeDecimal(3)) cout<<i<<endl;
}

/**
 * LOGIC - gray CODE
 * 
 * N=1     0: [0]
 *         1: [1]
 * 
 * N=2     0: 0|[0]    this bracket part is same as N=1 
 *         1: 0|[1]    with 0 in front
 *         -------
 *         3: 1|[1]    this bracket part is same as N=1 in reverse 
 *         2: 1|[0]    with 1 in front
 * 
 * N=3     0: 0|[00]
 *         1: 0|[01]   this bracket part is same as N=2
 *         3: 0|[11]   with 0 in front
 *         2: 0|[10]
 *         ---------
 *         6: 1|[10]
 *         7: 1|[11]   this bracket part is same as N=w in reverse
 *         5: 1|[01]   with 1 in front
 *         4: 1|[00]
 * 
 * this part repeats for all N and hence recursion or iterative method can be used
 * 
 * Recursive method;
 * N=1 0 1
 * N=2 0 1 (1+2) (0+2)  // addition is size of previous array = 2;
 *     0 1 3 2
 * N=3 0 1 3 2 (2+4) (3+4) (1+4) (0+4)
 *     0 1 3 2 6 7 5 4
 *               
 *                                N=3          N=2               N=2 in rev + sizeof(N=2)
 *                                          [0 1 3 2]           [(2+4) (3+4) (1+4) (0+4)]
 * 
 * recursive function             F(N)  =     F(N-1)   +         (rev(F(N-1))+ sizeof(N-1))

   1.binary representaion
 * reverse iterate from back
 * 
 * iterating from back {'1','0'}
 * 
 * push('1'+'1') and '1'+'0'   {0,01,11}
 *  push('1'+'0') and '0'+'0'   {00,01,11,10}
 * 
 * vector {'00','01','11','10'}
 * N=2 done
 * 
 * similarly do for N=3
 * 
 * 2. decimal 
 *     for each number if n = 2  we add set bit at n-1 pos i.e (1<<(log2(n))) ex. n=2 1<<1 = 2   n=3  1<<2=4 
 *  vector {0,1}
 *  N=1 done
 * 
 * 
 *  reverse iterate from back
 * 
 *  iterating from back {1,0}
 * 
 *  push(pow(2,1)+1)   {0,1,3}   pow(2,1)  1<<1  = 2^1 = 2
 *  push(pow(2,0)+1)   {0,1,3,2}
 * 
 *  vector {0,1,3,2}
 *  N=2 done
 *  similarly do for N=3
 */
