// Count of divisors
// Problem Description

// Given an array of integers A, find and return the count of divisors of each element of the array.

// NOTE: Order of the resultant array should be same as the input array.



// Problem Constraints
// 1 <= length of the array <= 100000
// 1 <= A[i] <= 106



// Input Format
// The only argument given is the integer array A.



// Output Format
// Return the count of divisors of each element of the array in the form of an array.



// Example Input
// Input 1:

//  A = [2, 3, 4, 5]
// Input 2:

//  A = [8, 9, 10]


// Example Output
// Output 1:

//  [2, 2, 3, 2]
// Output 1:

//  [4, 3, 4]


// Example Explanation
// Explanation 1:

//  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
//  So the count will be [2, 2, 3, 2].
// Explanation 2:
//  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
//  So the count will be [4, 3, 4]
import java.util.*;
class DivisorCount 
{
    static int max = 1000000;
    static int[] spf = new int[max+1];
    void SOE()
    {
        spf[0]=1;
        for(int i=1; i<=max; i++) spf[i]=i;
        for(int i=2; i*i<=max; i++)
            if(spf[i]==i)
                for(int j=i*i; j<=max; j+=i)
                    if(spf[j]==j) 
                        spf[j]=i;
    }
    ArrayList<Integer> Divisors(ArrayList<Integer> A) 
    {
        SOE();
        ArrayList<Integer> B = new ArrayList<Integer>(A.size());
        for(int i:A)
        {
            int temp = i;
            int ans = 1;
            while(temp!=1)
            {
                int cnt = 1;
                int x = spf[temp];
                while(temp!=1 && (temp%x)==0)
                {
                    cnt++;
                    temp=temp/x;
                }
                ans*=cnt;
            }
            B.add(ans);
        }
        return B;
    }
    void print(ArrayList<Integer> B) 
    {
        for(int i:B) System.out.print(i+" ");
    }
    public static void main(String[] args)
    {
        DivisorCount D1 = new DivisorCount();
        ArrayList<Integer> A = new ArrayList<Integer>(4);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        ArrayList<Integer> B = new ArrayList<Integer>(4);
        B = D1.Divisors(A);
        D1.print(B);
        
    }   
}
/**
 *  36 = 2*2*3*3 prime factors
 *  2- 2 a
 *  3- 2 b
 * number of divsor = (a+1)(b+1)
 *                  = (3)(3)
 *                  = 9
 * 36 =  1 2 3 4 6 9 12 18 36 = 9 divisors.
 *    
 */
