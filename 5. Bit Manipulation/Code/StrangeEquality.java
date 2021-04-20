// Strange Equality
// Problem Description

// Given an integer A.
// Two numbers X and Y are defined as follows:

// X is the greatest number smaller than A such that XOR sum of X and A is the same as the sum of X and A.
// Y is the smallest number greater than A such that XOR sum of Y and A is the same as the sum of Y and A.
// Find and return the XOR of X and Y.

// NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

// NOTE 2: Your code will be run against a maximum of 100000 Test Cases.



// Problem Constraints
// 1 <= A <= 109



// Input Format
// First and only argument is an integer A.



// Output Format
// Return an integer denoting the XOR of X and Y.



// Example Input
// A = 5


// Example Output
// 10


// Example Explanation
// The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
class StrangeEquality {
    StrangeEquality(int A)
    {
        int T = A;
        int MSB = (int)(Math.log(T)/Math.log(2));
        /**
     * log2(A) gives MSB 
        why?
        to find binary representation we divide number by 2 till 1 comes
        8 msb 3
        2 power 3 = 8 
        2 power x = y   ===   log2(y) = x
        log2(8) = 3(msb) 
     * 
     */
        for(int i=0; i<=MSB; i++) T = T^(1<<i); //flipbit
        System.out.print(T^(1<<(MSB+1)));
    }
    public static void main(String[] args) {
        new StrangeEquality(5);
    }
}
/**
 * ex: 5 
    5: 0101
    MSB = 2

    to get number less than 5 i.e X we need to change all unset bits to set to get addition.
     0101
    +0010
     0111 = 7 
     flip all bit upto msb
    similar
    to get number greater than 5 i.e X we need to change msb+1 bit

     0101
    +1000
     1101 = 13
     2^8 = 10
 * 
 */
