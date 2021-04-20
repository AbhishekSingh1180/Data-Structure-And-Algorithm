// Excel Column Number
// Problem Description

// Given a column title as appears in an Excel sheet, return its corresponding column number.



// Problem Constraints
// 1 <= length of the column title <= 5



// Input Format
// Input a string which represents the column title in excel sheet.



// Output Format
// Return a single integer which represents the corresponding column number.



// Example Input
// Input 1:

//  AB
// Input 2:

//  ABCD


// Example Output
// Output 1:

//  28
// Output 2:

//  19010


// Example Explanation
// Explanation 1:

//  A -> 1
//  B -> 2
//  C -> 3
//  ...
//  Z -> 26
//  AA -> 27
//  AB -> 28
/**
     logic
     
     A - Z    1 - 26
     AB     A= 26*A(1)+2
     AZB    A(26*26*A(1) + 26*Z(26) + B(2))
     1's = 26^0
     10's = 26^1
     100's = 26^2
     **/
import java.util.*;
class ExcelColNum {

    static int titleToNumber(String A)
    {
        int num = 0;
        for(int i=A.length()-1; i>=0; i--)
        {
            num+=((int)A.charAt(i)-64)*Math.pow(26,A.length()-i-1);

        }
        return num;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String A;
        A = in.nextLine();
        System.out.print(titleToNumber(A));
        in.close();
    }
    
}
