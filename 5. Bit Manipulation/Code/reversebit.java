// Reverse Bits
// Problem Description

// Reverse the bits of an 32 bit unsigned integer A.



// Problem Constraints
// 0 <= A <= 232



// Input Format
// First and only argument of input contains an integer A.



// Output Format
// Return a single unsigned integer denoting the decimal value of reversed bits.



// Example Input
// Input 1:

//  0
// Input 2:

//  3


// Example Output
// Output 1:

//  0
// Output 2:

//  3221225472


// Example Explanation
// Explanation 1:

//         00000000000000000000000000000000    
// =>      00000000000000000000000000000000
// Explanation 2:

//         00000000000000000000000000000011    
// =>      11000000000000000000000000000000
class reversebit
{
    static long checkbit(long N, long pos) { return ((N>>pos)&1L);}
    static long setbit(long N, long pos) { return N|(1L<<pos);}
    static long unsetbit(long N, long pos) { return N&(~(1L<<pos));}
    static long reverse(long N)
    {
        long Msb = 31, Lsb = 0;//msb bits 31
        while(Msb>Lsb)//till msb pos is greater then lsb
        {
            long Mbit = checkbit(N,Msb), Lbit = checkbit(N,Lsb); //check msb and lsb 
            if(Mbit!=Lbit) // we will only swap if msb and lsb bcz if same no swap is required.
            {
                N = (Mbit==1L)?setbit(N,Lsb):unsetbit(N,Lsb); // if msb is 1 then unset it or viceversa
                N = (Lbit==1L)?setbit(N,Msb):unsetbit(N,Msb); // if lsb is 1 then unset it or viceversa
            }
            Msb--;Lsb++;
        }
        return N;
    }   
    public static void main(String[] args) {
        long  N = 3;
        System.out.print(reverse(N));
    }
}