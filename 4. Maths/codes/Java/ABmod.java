import java.util.Scanner;
class ABmod
{
    static int solve(int A, int B)
    {
        return Math.abs(A-B);
    }
    public static void main(String[] args)
    {
        int A,B;
        Scanner in = new Scanner(System.in);
        A = in.nextInt();
        B = in.nextInt();
        System.out.print(solve(A,B));
        in.close();
    }
}