// Permutations
// Problem Description

// Given an integer array A of size N denoting collection of numbers , return all possible permutations.

// NOTE:

// No two entries in the permutation sequence should be the same.
// For the purpose of this problem, assume that all the numbers in the collection are unique.
// WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
// If you do, we will disqualify your submission retroactively and give you penalty points.


// Problem Constraints
// 1 <= N <= 9



// Input Format
// Only argument is an integer array A of size N.



// Output Format
// Return a 2-D array denoting all possible permutation of the array.



// Example Input
// A = [1, 2, 3]


// Example Output
// [ [1, 2, 3]
//   [1, 3, 2]
//   [2, 1, 3] 
//   [2, 3, 1] 
//   [3, 1, 2] 
//   [3, 2, 1] ]


// Example Explanation
// All the possible permutation of array [1, 2, 3].

//Duplicates are allowed
import java.util.ArrayList;
import java.util.Arrays;

class Permutations
{
    private ArrayList<ArrayList<Integer>> ans;
    private void swap(ArrayList<Integer> A, int start, int end)
    {
        int temp = A.get(start);
        A.set(start,A.get(end));
        A.set(end,temp);
    }
    private void permutation( ArrayList<Integer> A, int start, int end)
    {
        if(start==end) ans.add(new ArrayList<Integer>(A)); //providing here a new instance of A so that it has no relation to previous A;
        else
        {
            for(int i=start; i<=end; i++)
            {
                swap(A,start,i); //   gives swap and permute rest
                permutation(A,start+1,end);
                swap(A,start,i); //   goes for original array so that changes by swap can be reverse for further parts see line no. 2 in logic
            }
        }
    }
    ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A)
    {
        ans = new ArrayList<ArrayList<Integer>>();
        permutation(A,0,A.size()-1);
        return ans;
    }
    public static void main(String[] args) {
        Permutations num = new Permutations();
        ArrayList<ArrayList<Integer>> P = num.permute(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
        for(int i=0; i<P.size(); i++)
        {
            for(int j=0; j<P.get(i).size(); j++)
            {
                System.out.print(P.get(i).get(j)+" ");
            }
            System.out.println();
        }        
    }
}
/**
 * 
 * 
 *       Use recursion tree
 * 
 *       [] - fixed 
 *       rest = permute further
 *                                             INDEX : 0 1 2
 *                                                     A B C                                                    line 1
 *                                                       | 
 *                            .--------------------------.--------------------------.   
 *                            |                          |                          |             
 *                         [A] B C                    [B] A C                    [C] B A                        line 2
 *                        SWAP(0,0)                  SWAP(0,1)                  SWAP(0,2)
 *                            |                          |                          |         
 *                    .---------------.          .---------------.          .--------------.       
 *                 [A B] C         [A C] B    [B A] C         [B C] A    [C B] A        [C A] B                 line 3
 *                SWAP(1,1)       SWAP(1,2)  SWAP(1,1)       SWAP(1,2)  SWAP(1,1)      SWAP(1,2)
 * 
 *                 note from    ABC (Line 1)  TO    [B] A C  (line 2)  we swap
 *                 and now for    ABC (Line 1)  TO    [C] B A  (line 2)  we need original ABC but we swap to BAC 
 *                 BAC  swap to  CAB [wrong]   thats why there are two swap to revert changes BAC revert ABC swap CBA  
 */               