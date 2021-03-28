// Very Large Power
// Problem Description

// Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

// "^" means power ,

// "%" means "mod", and

// "!" means factorial.



// Problem Constraints
// 1 <= A, B <= 5e5



// Input Format
// First argument is the integer A

// Second argument is the integer B



// Output Format
// Return one integer, the answer to the problem



// Example Input
// Input 1:

// A = 1
// B = 1
// Input 2:

// A = 2
// B = 2


// Example Output
// Output 1:

// 1
// Output 2:

// 4


// Example Explanation
// Explanation 1:

//  1! = 1. Hence 1^1 = 1.
// Explanation 2:

//  2! = 2. Hence 2^2 = 4.
#include <iostream>
using namespace std;
long powerMod(long A, long B, long M)
    {
        if(B==0) return 1;
        if(B==1) return A%M;
        long X = powerMod(A,B/2,M);
        if(B%2==0) return (X%M*X%M)%M;
        else return (X%M*X%M*A%M)%M;
    }
int solve(int A, int B) {
        long R = 1;
        long M = 1000000007;
        for(long i = 2; i <= B; i++) R = (R*i)%(M-1);
        int ans = (int)powerMod((long)A,R,M);
        return ans;
}
int main()
{
    cout<<solve(35,68);
}
logic

// A^B!%M   M=1000000007
// fermat litte theorem
// A^(p-1) == 1modp
// A^(B-1) = 1modB
// A^B!= A^(M-1) + A^(M-1) + .... + A^(M-1) + A^R(remainder)
// A^B!= A^(M-1)*N + A^R
// A^(M-1)*N = 1 acc. to fermat sir = 1modM = 1
// A^B!%M = A^R%M
// B! = (M-1)N + R
// R = B!%(M-1)

