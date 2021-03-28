class EnumGCD
{
    static String find(String A, String B) {
        if(A.equals(B)) return A;
        else return "1";
    }
    public static void main(String[] args) {
        String A = "100000", B = "100001";
        System.out.print(find(A,B));
    }
}