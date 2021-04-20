// Number of Digit One
// Problem Description

// Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers less than or equal to A.



// Problem Constraints
// 0 <= A <= 109



// Input Format
// The only argument given is the integer A.



// Output Format
// Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.



// Example Input
// Input 1:

//  A = 10
// Input 2:

//  A = 11


// Example Output
// Output 1:

//  2
// Output 2:

//  4


// Example Explanation
// Explanation 1:

// Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
// Explanation 2:

// Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.

class OneDcount {
    static int Dcount(int N)
    {
        int count = 0;
        int current = 0, before = 0, after = 0;
        int i = 1;
        while((N/i)!=0)
        {
            current = (N/i)%10;
            before = (N/(i*10));
            after = N - (N/i)*i;

            if (current > 1) count+=((before+1)*i);
            else if (current == 0) count+=(before*i);
            else if (current == 1) count+=(before*i)+(after+1);
            i*=10;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.print(Dcount(123));
    }
}

// Let’s do it differently. We can count the number of 1’s for each different positions, ONEs, TENs, HUNDREDs etc and sum them up.

// For number less than 10, the answer is 1. For two-digit numbers, e.g. when N=13, there are 2 numbers that the position (ONEs) has 1, which is 1 and 11. There are 4 numbers that the highest digit (TENs) is 1, which is 10, 11, 12 and 13. Therefore f(13) = 2 + 4.

// Another example, when N = 23, there are 3 numbers for position ONE, which are 1, 11 and 21. There fore 10 numbers for position TEN, which are from 10 to 19. therefore, f(23) = 3 + 10

// When N=123, the numbers for ONEs are 1, 11, 21, … 91, 101, 111 and 121. The numbers for TENs are 10~19, and 110~119. The numbers for HUNDREDs are 100~123.
 
//  * Count = 0
// I=1             N=123
// Current = 0 after = 0 before = 0
// ============================================
// Loop 1 ::  I=1 / N=123  / count = 0
 
// Current = (123/1)%10 = 3
// Before = (123/1*10) = 12
// After = 123 - (123/1) * 1 = 0
 
// if(3>1)
//     count = 0 + (12+1)*1  = 13
//       1 11 21 31 41 51 61 71 81 91 101 111 121 
 
// Else if(3 == 0)
//     count = 0 + (12*1) = 12 false
//     120 -12 1’s
//     121 = 13 1’s
//     12x x>1 13 1’s
 
// Else if(3==1)
//     count = 0 + (12*1) + (0*1) =12 false
// I= I * 10
// ============================================
// Loop 2 ::  I=10 / N=123  / count = 13
 
// Current = (123/10)%10 = 2
// Before = (123/10*10) = 1
// After = 123 - (123/10) * 10 = 
 
// if(2>1)
//     count = 13 + (1+1)*10  = 33
//      10 11 -19 110 111-119   20 + 13 true bitch!!!
 
// Else if(3 == 0)
//     count = 13 + (1*10) = 23 false
 
// Else if(3==1)
//     count = 13 + (1*10) + (0+1) =24 false
// I= I * 10
// =============================================
// N=113
// 1:: 1 11 21 31 41 51 61 71 81 91 101 111 = 12
// 10:: 10 11 12 13 14 15 16 17 18 19
//       110 111 112 113 
// 12 + 1*10 + 3 **/
