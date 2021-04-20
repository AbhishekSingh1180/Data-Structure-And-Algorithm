// Delete one
// Problem Description

// Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

// Find the maximum value of GCD.



// Problem Constraints
// 2 <= N <= 105
// 1 <= A[i] <= 109



// Input Format
// First argument is an integer array A.



// Output Format
// Return an integer denoting the maximum value of GCD.



// Example Input
// Input 1:

//  A = [12, 15, 18]
// Input 2:

//  A = [5, 15, 30]


// Example Output
// Output 1:

//  6
// Output 2:

//  15


// Example Explanation
// Explanation 1:

 
//  If you delete 12, gcd will be 3.
//  If you delete 15, gcd will be 6.
//  If you delete 18, gcd will 3.
//  Maximum vallue of gcd is 6.
// Explanation 2:

//  If you delete 5, gcd will be 15.
//  If you delete 15, gcd will be 5.
//  If you delete 30, gcd will be 5.
import java.util.ArrayList;
class maxGCD {

    int max(int A, int B) {return Math.max(A,B);}
    int min(int A, int B) {return Math.min(A,B);}

    int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    int MaxGcd(ArrayList<Integer> A)
    {
        int N = A.size();
        int[] PreGCD = new int[N];
        int[] SufGCD = new int[N];
        PreGCD[0] = A.get(0);
        SufGCD[N-1] = A.get(N-1);
        for(int i=1; i<N; i++) PreGCD[i] = gcd(max(PreGCD[i-1],A.get(i)),min(PreGCD[i-1],A.get(i))); //prefix gcd
        for(int i=N-2; i>=0; i--) SufGCD[i] = gcd(max(SufGCD[i+1],A.get(i)),min(SufGCD[i+1],A.get(i))); //suffix gcd
        int maxgcd = 1;
        for(int i=0; i<N; i++)
        {
            if(i==0) maxgcd = max(maxgcd,SufGCD[i+1]); // 0th element
            else if(i==(N-1)) maxgcd = max(maxgcd,PreGCD[i-1]); // Nth element
            else maxgcd = max(maxgcd,gcd(PreGCD[i-1],SufGCD[i+1]));
        }
        return maxgcd;
    }
    public static void main(String[] args) 
    {
        maxGCD Num = new maxGCD();
        ArrayList<Integer> A = new ArrayList<Integer>(3);
        A.add(12); A.add(15); A.add(18);
        System.out.print(Num.MaxGcd(A));
    }
}
/**
 * 12 15 18
 * compute prefix and suffix gcd array
 * P[N+2] and S[N+2] bcz we are comparing i-1 and i+1 while ignoring i
 *     0  1 2
 * P:  12 3 3 
 * S:  3 3 18 
 * say max gcd = 1;
 * 
 * delete 0i element  max = S[i+1] = 3 // boundary condition
 * delete 1i element  max = max(max,gcd(p[i-1],s[i+1])) = 6
 * delete 2i element  max = max(max,P[i-1]) = 3 // boundary condition
 * max gcd = 6;
 */
