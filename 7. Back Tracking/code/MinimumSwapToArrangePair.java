import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwapToArrangePair{

    public void swap(int i, int j, ArrayList<Integer> B){
        int temp = B.get(i);
        B.set(i, B.get(j));
        B.set(j, temp);
    }
    
    public int minSwap(int start, int end, ArrayList<Integer> B, int[] pair){
        
        if(start == end){ //reach end 
            return 0;
        }
        
        int swap1 = 0 , swap2 = 0;
        if(pair[B.get(start)]!=B.get(start+1)){  //check if pair are already arranged
            
            // Swap 1st element of pair 
            int pos = B.indexOf(pair[B.get(start+1)]);
            swap(start, pos, B);
            swap1 += minSwap(start+2, end, B, pair)+1; //add 1 for swap
            swap(pos, start, B);
            
            // Swap 2nd element of pair
            pos = B.indexOf(pair[B.get(start)]);
            swap(start+1, pos, B);
            swap2 += minSwap(start+2, end, B, pair)+1; // add 1 for swap
            swap(pos, start+1, B);
            
        } 
        else return minSwap(start+2, end, B, pair); // if arranged move next
        
        return Math.min(swap1, swap2); // return the min of (n-1 pair swaps)
    }
    
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C) {
        int[] pair = new int[2*A+1];  //map pairs 
        pair[0] = 0;
        for(ArrayList<Integer> map: C){
            pair[map.get(0)] = map.get(1);
            pair[map.get(1)] = map.get(0);
        }
        return minSwap(0, 2*A, B, pair);
    }
    public static void main(String[] args) {
        MinimumSwapToArrangePair pr = new MinimumSwapToArrangePair();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 5, 6, 4, 1, 2));
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        
        B.add(new ArrayList<Integer>(Arrays.asList(1,3)));
        B.add(new ArrayList<Integer>(Arrays.asList(2,6)));
        B.add(new ArrayList<Integer>(Arrays.asList(4,5)));
        
        System.out.println(pr.solve(3, A, B));
    }   
}
/**
 *  since we have to arrange pair in minimum swap
 *  we have two choices either swap 1st element of current unarranged pair with right element or 2nd element and move
 *  or move to next pair if already arranged
 */