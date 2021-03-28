import java.util.ArrayList;
class RearrangeArray 
{
    static void arrange(ArrayList<Integer> A) 
    {
        int N = A.size();
        for(int i=0; i<N; i++) A.set(i,A.get(i)*N);
        for(int i=0; i<N; i++) A.set(i,(A.get(i) + A.get(A.get(i)/N)/N));
    }
    static void print(ArrayList<Integer> A ,int N)
    {
        for(int i:A) System.out.print(i%N+" ");
    }  
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(4); A.add(0); A.add(2); A.add(1); A.add(3);
        arrange(A);
        print(A,A.size());
    }  
}
