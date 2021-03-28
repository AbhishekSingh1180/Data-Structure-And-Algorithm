// Reverse Bits
// Problem Description

// Reverse the bits of an 32 bit unsigned integer A.



// Problem Constraints
// 0 <= A <= 232



// Input Format
// First and only argument of input contains an integer A.



// Output Format
// Return a single unsigned integer denoting the decimal value of reversed bits.



// Example Input
// Input 1:

//  0
// Input 2:

//  3


// Example Output
// Output 1:

//  0
// Output 2:

//  3221225472


// Example Explanation
// Explanation 1:

//         00000000000000000000000000000000    
// =>      00000000000000000000000000000000
// Explanation 2:

//         00000000000000000000000000000011    
// =>      11000000000000000000000000000000
#include <iostream>
#define U unsigned int
using namespace std;
U checkbit(U N, U pos) { return (N>>pos)&1;}
U setbit(U N, U pos) { return N|(1<<pos);}
U unsetbit(U N, U pos) { return N&(~(1<<pos));}
U reversebit(U N)
{
    U Msb = sizeof(N)*8-1 , Lsb = 0;  //msb bits 31
    while(Msb>Lsb) //till msb pos is greater then lsb
    {
        U Mbit = checkbit(N,Msb) , Lbit = checkbit(N,Lsb); //check msb and lsb 
        if(Mbit!=Lbit) // we will only swap if msb and lsb bcz if same no swap is required.
        {
            N = Mbit?setbit(N,Lsb):unsetbit(N,Lsb); // if msb is 1 then unset it or viceversa
            N = Lbit?setbit(N,Msb):unsetbit(N,Msb); // if lsb is 1 then unset it or viceversa
        }
        Msb--;Lsb++; //inc lsb and dcr msb
    }
    return N;
}
int main()
{
    unsigned int N = 3;
    cout<<reversebit(N);
}