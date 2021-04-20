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
class DivisorGame {
    static int max(int A, int B) {return Math.max(A,B);}
    static int min(int A, int B) {return Math.min(A,B);}
    static int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    static int divisors(int A, int B, int C) {
        return A/(B*C/gcd(max(B,C),min(B,C)));
        //LCM will divide all the commmon elements in 2 and 3 multiples upto 12
    }
    public static void main(String[] args) {
        System.out.print(divisors(12,2,3));
    }
    
}

