import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MinXor {
    private int min(int A, int B) { return (A>=B)?B:A;}
    MinXor(ArrayList<Integer> A)
    {
        Collections.sort(A);
        int MX = A.get(0)^A.get(1);
        for(int i=1; i<A.size()-1; i++)
            MX = min(MX,(A.get(i)^A.get(i+1)));
        System.out.print(MX);
    }
    
    public static void main(String[] args) {
        new MinXor(new ArrayList<Integer>(Arrays.asList(0, 7, 4, 9)));
    }
}
