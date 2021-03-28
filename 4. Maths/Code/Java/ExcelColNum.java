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
