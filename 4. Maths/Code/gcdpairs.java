// ALL GCD PAIR
// Problem Description

// Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

// Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



// Problem Constraints
// 1 <= N <= 10000

// 1 <= A[i] <= 109



// Input Format
// The first and only argument given is the integer array A.



// Output Format
// Find and return the original numbers which are used to calculate the GCD array in any order.



// Example Input
// Input 1:

//  A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
// Input 2:

//  A = [5, 5, 5, 15]


// Example Output
// Output 1:

//  [2, 8, 10]
// Output 2:

//  [5, 15]


// Example Explanation
// Explanation 1:

//  Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
//  2 is the gcd between 2 and 8, 2 and 10.
//  8 and 10 are the gcds pair with itself.
//  Therefore, [2, 8, 10] is the original array.
// Explanation 2:

//  Initially, array A = [5, 5, 5, 15].
//  5 is the gcd between 5 and 15.
//  15 is the gcds pair with itself.
//  Therefore, [5, 15] is the original array.

import java.util.ArrayList;
import java.util.Collections;

class gcdpairs
{   
    static int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    static void push(int X, ArrayList<Integer> orginal, int[] freqA)
    {
        int N = orginal.size();
        for(int i=0; i<N; i++) freqA[gcd(X,orginal.get(i))]-=2;
        // remove elements from freq array whose gcd are from biggest element and rest.
        freqA[X]--;// reduce biggest element by 1
        orginal.add(X);// push biggest element to original array
    }
    static ArrayList<Integer> originalPairs(ArrayList<Integer> A)
    {
        int N = A.size();
        Collections.sort(A);

        int[] freqA = new int[A.get(N-1)+1];
        for(int i=0; i<N; i++) freqA[A.get(i)]++;

        ArrayList<Integer> orginal = new ArrayList<Integer>();

        for(int i=N-1; i>=0; i--) if(freqA[A.get(i)]>0) push(A.get(i),orginal,freqA);
        return orginal;
    }
    static void print(ArrayList<Integer> A)
    {
        for(int i=A.size()-1; i>=0; i--) System.out.print(A.get(i)+" ");
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2); A.add(2); A.add(2); A.add(2); A.add(8); A.add(2); A.add(2); A.add(2); A.add(10);
        ArrayList<Integer> B = originalPairs(A);
        print(B);
    }
}