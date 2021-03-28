// Rectangle Area
// Problem Description

// Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.

// For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the second rectangle it's bottom left corner is (E, F) and top right corner is (G, H).

// Find and return the overlapping area of the two rectangles.



// Problem Constraints
// -104 <= A <= C <= 104
// -104 <= B <= D <= 104
// -104 <= E <= G <= 104
// -104 <= F <= H <= 104


// Input Format
// The eight arguments given are the integers A, B, C, D, E, F, G and H.



// Output Format
// Return the overlapping area of the two rectangles.



// Example Input
// Input 1:

//  A = 0   B = 0
//  C = 4   D = 4
//  E = 2   F = 2
//  G = 6   H = 6
// Input 2:

//  A = 0   B = 0
//  C = 4   D = 4
//  E = 2   F = 2
//  G = 3   H = 3


// Example Output
// Output 1:

//  4
// Output 2:
//  1
#include<iostream>
using namespace std;
int solve(int A, int B, int C, int D, int E, int F, int G, int H) 
{
    int X = min(G,C) - max(E,A);
    int Y = min(H,D) - max(F,B);
    if(X<0 || Y<0) return 0;
    else return X*Y;
}
int main()
{
 int A = 0, B = 0, C = 4, D = 4, E = 2, F = 2, G = 6, H = 6;
 cout<<solve(A,B,C,D,E,F,G,H);
}
/**
 * logic
 * we will check on x and y axis which point line has bound
 * 
 *      H|    _______
 *       |   |       |
 *      D|___|____   |
 *       |   |    |  |
 *      F|   |____|__|   
 *       |        |
 *      B|________|________           
 *        A   E   C   G
 *  Y-axis
 *  min(H,D) //inner bound
 *  max(F,B) //outer bound
 * 
 *  X-axis
 *  min(G,C) //inner bound
 *  max(E,A) //outer bound
 * 
 * /

