import java.util.ArrayList;

class NonRepeatElement {
    NonRepeatElement(final ArrayList<Integer> A)
    {
        int xor = 0; // x^0 = x  doesn't matter
        for(Integer i:A) xor^=i;
        System.out.print(xor);
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1); A.add(2); A.add(2); A.add(3); A.add(1);
        new NonRepeatElement(A);
    }
}
