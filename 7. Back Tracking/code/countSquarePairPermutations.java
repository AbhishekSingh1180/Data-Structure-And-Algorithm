import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class countSquarePairPermutations {
    countSquarePairPermutations(ArrayList<Integer> A){
        HashMap<Integer,Integer> map = new HashMap<>(); // To counter duplicate values
        for(int i : A){
            if(!map.containsKey(i)) map.put(i, 1);
            else map.put(i,map.get(i)+1);
        }
        if(A.size()==1)  System.out.println(0);// 1 element alone can't have squareful permutation 2 required atleast
        else System.out.println(countSquarePermutation(0, 0, A.size(), map));
    }
    public boolean isSquare(int N){
        int i = (int)Math.sqrt(N);
        return (i*i == N);
    }
    public int countSquarePermutation(int start, int prev, int end, HashMap<Integer,Integer> map){

        if(start==end) return 1;

        int cnt = 0;
        for(int i: map.keySet()){
            int val = map.get(i);
            if( start==0 || ( val!=0 && isSquare(prev+i))){
                map.put(i, val-1); //decrease element
                cnt += countSquarePermutation(start+1, i, end, map); //next element move
                map.put(i, val); //restore
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        new countSquarePairPermutations(
                                new ArrayList<Integer>( 
                                        Arrays.asList(1,17,8)));
    }
}
/**
 * LOGIC 
 * 
 * 
 * since elements can repeat 
 * we need to create a hashmap
 *  now through this hash map we will pick element by decr/incr count at choice of picking element that is squareful 
 *  with prev element and end when element picked = A size
 */
