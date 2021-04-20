
// Pair Sum divisible by M
// Problem Description

// Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

// Since the answer may be large, return the answer modulo (109 + 7).



// Problem Constraints
// 1 <= length of the array <= 100000
// 1 <= A[i] <= 109
// 1 <= B <= 106



// Input Format
// The first argument given is the integer array A.
// The second argument given is the integer B.



// Output Format
// Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).



// Example Input
// Input 1:

//  A = [1, 2, 3, 4, 5]
//  B = 2
// Input 2:

//  A = [5, 17, 100, 11]
//  B = 28


// Example Output
// Output 1:

//  4
// Output 2:

//  1


// Example Explanation
// Explanation 1:

//  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
//  So total 4 pairs.

import java.util.ArrayList;
class PairSumMod
{

    static final int mod = 1000000007;
    int solve(ArrayList<Integer> A, int B)
    {
        int[] MA = new int[B];
        for(int i=0; i<A.size(); i++) MA[A.get(i)%B]++;
        //for(int i:MA) System.out.println(i);
        long Z = MA[0];
        long count = ((Z*(Z-1))/2)%mod;
        int start=1, end=B-1;
        while(start<=end)
        {
            long X = MA[start];
            long Y = MA[end];
            if(start==end)
            {
                count = (count + (X*(X-1))/2)%mod;
                break;
            }
            count = (count + (X*Y))%mod;
            start++;
            end--;
        } 
        return (int)count;
    }
    public static void main(String[] args)
    {
        PairSumMod P = new PairSumMod();
        ArrayList<Integer> A = new ArrayList<Integer>(5);
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        int B = 2;
        int ans = P.solve(A,B);
        System.out.print(ans);
        
    }
}
// A[]: 1 2 3 4 5
// B: 2
// A%B : 1 0 1 0 1
// B[] : 2(0) 3(1)

// 2!/1!*2! + 3!/2!*1! if P[i]==P[j] i==j comninations
// else p[i]*p[j]