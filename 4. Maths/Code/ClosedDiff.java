// Closed Differences
// Problem Description

// You are given an integer array A of size N.

// Consider any pair i , j, if the difference | A[i] - A[j] | doesn't belongs to A then append the difference value to the array.
// Keep on adding the elements untill no new elements can be formed.
// Find the size of the final array.

// Note: Initially no two elements are equal.



// Problem Constraints
// 1 <= N <= 100000
// 1 <= A[i] <= 1e9


// Input Format
// Input contains an integer array A



// Output Format
// Return an integer denoting the size of the final array.



// Example Input
// Input 1:

//  A = [0, 3, 4]
// Input 2:

//  A = [2, 4, 6, 7]


// Example Output
// Output 1:

//  5
// Output 2:

//  7


// Example Explanation
// Explanation 1:

//  Initially, array A = [0, 3, 4].
//  Consider two elements 4 , 3 and their difference |4 - 3| = 1. 
//  1 is not present in the array. Now, the array becomes [0, 3, 4, 1].

//  Take another pair 1 , 3 and their difference |1 - 3| = 2.
//  2 is added to the array.

//  Now, no pair exists which gives us a new element.

//  Final array is [0, 3, 4, 1, 2].

//  So, our answer is 5.
import java.util.ArrayList;
class ClosedDiff
{
    static int max(int A, int B){return Math.max(A,B);}
    static int min(int A, int B){return Math.min(A,B);}
    static int gcd(int A, int B)
    {
        if(B==0) return A;
        return gcd(B,A%B);
    }
    static int allDiffArr(ArrayList<Integer> A)
    {   
        int n = A.size();
        if(n==1) return 1;
        int Ag = A.get(0);
        int maxElm = A.get(0);
        Boolean zero = false;
        for(int i:A)
        {
            if(i==0) zero = true;
            if(i>maxElm) maxElm = i;
            Ag = gcd(max(Ag,i),min(Ag,i));
        }
        return zero?(maxElm/Ag)+1:maxElm/Ag;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2); A.add(4); A.add(6); A.add(7);
        System.out.print(allDiffArr(A));
    }
    // if gcd(array) = 1 min element that can be add is 1 ie by subtracting 1 from max we can get 
// max-1 and again (max-1)-1 so on till 2 hence elements added = max/min or max/gcd(array) 
// if zero is present return max/gcd(array)+1 else max/gcd(array)  gcd(0,a)=a hence no effect extra element
}