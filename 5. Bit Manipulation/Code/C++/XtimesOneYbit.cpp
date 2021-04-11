//Every number repeats x times except one number which repeats y times (y<x);
// suppose x=3 y=1
#include <iostream>
#include <vector>
using namespace std;
int imposterNum(vector<int> &num)
{
    int x = 0;
    for(int i=0; i<32; i++)
    {
        int setBit = 0;
        for(int j:num)
        {
            if(((j>>i)&1)==1) setBit++;
        }
        x += ((setBit%3)==1)?(1<<i):0; // 3K+1   num%3 == 1  
    }
    return x;
}
int main()
{
    vector<int> num{3,3,3,7,4,4,4,5,5,5,8,8,8};
    cout<<imposterNum(num);
}
/**
 * LOGIC
 * 
 * if every number repeats x times except 1 num y times
 * 
 * [3 3 3] [7] [4 4 4] [5 5 5] [8 8 8]
 * 
 * lets write binary of each number
 * 
 * 3:   0011  X3
 * 7:   0111  X1
 * 4:   0100  X3
 * 5:   0101  X3
 * 8:   1000  X3
 * 
 * Now lets add all bits for 0th position
 * 
 * 3(three setbit in 3) + 1(one setbit in 7) + 0 + 3 + 0
 * count0 = 7
 * similarly for 2nd 3rd 4th pos
 * count1 = 4
 * count2 = 7
 * count3 = 3
 * 
 * now observe that all set bits position in unique element 7 and setbit count for those element
 *      pos:    3    2    1    0
 *        7:    0    1    1    1
 *    count:    3    7    4    7
 *     form:   3K  3K+1  3k+1  3K+1
 *    
 *    observe all set bit pos count are of form 3k+1 and unsetbit of form 3k
 *    why?
 * 
 *    because bitwise if we add set bit for a particular number
 *    [3 3 3] [4 4 4] [5 5 5] [8 8 8]  [7]   
 *       x3      x3      x3     x3      x1  =   3K+1
 *          count will always be of form 
 *                  x(times)+y   or   x(times)
 *                     setbit           no setbit
 * 
 * we need to get count if count if of form xk+y i.e  3k+1(in this example)  ans+ = (pow(2,i)) where i is bit position
 *          2^3  2^2  2^1  2^0
 *           0    1    1    1    =   7
 * 
 */
