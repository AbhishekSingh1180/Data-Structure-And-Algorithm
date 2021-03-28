// Divisor game
// Problem Description

// Scooby has 3 three integers A, B and C.

// Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell number of special integers less than or equal to A.



// Problem Constraints
// 1 <= A, B, C <= 109



// Input Format
// First argument is a positive integer A
// Second argument is a positive integer B
// Third argument is a positive integer C



// Output Format
// One integer corresponding to the number of special integers less than or equal to A.



// Example Input
// Input 1:

//  A = 12
//  B = 3
//  C = 2
// Input 2:

//  A = 6
//  B = 1
//  C = 4


// Example Output
// Output 1:

//  2
// Output 2:

//  1


// Example Explanation
// Explanation 1:

//  The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
// Explanation 2:

//  Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
/**int x = max(B,C);
    int y = min(B,C);
    int count = 0;
    for(int i=x;i<=A;i+=x) i%y==0?count++:count+=0;
    return count;
      logic 1 
        12 3 2
        3 6 9 12
        - T - T
      logic 2
        12 2 3
        gcd(b,c)*lcm(b,c)=b*c
        1 2 3 4 5 [6] 7 8 9 10 11 [12]
        6 - lcm(2,3)
        6 12| 18 .... answers
        12/6 = 2
        lcm(2,3) = 2*3/gcd(2,3)
    **/
#include<iostream>
using namespace std;
int gcd(int A,int B)
{
    if(B==0) return A;
    return gcd(B,A%B);
}
int solve(int A, int B, int C)
{
    int x = max(B,C);
    int y = min(B,C);
    
    // int count = 0;
    // for(int i=x; i<=A ; i+=x) if(i%y==0) count++;
    
    // return count;
    return A/((B*C)/gcd(x,y));
}
int main()
{
     cout<<solve(12,3,2);
}