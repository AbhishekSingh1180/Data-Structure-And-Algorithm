//Given N Distinct array elements print all subsets in lexicographical order
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class printLexiSubset {
    printLexiSubset(ArrayList<Integer> Arr)
    {
        Collections.sort(Arr);
        lexiSubset(0,Arr,new ArrayList<Integer>());
    }
    void print(ArrayList<Integer> sub)
    {
        for(int i:sub) System.out.print(i+" ");
        System.out.println();
    }
    void lexiSubset(int start, ArrayList<Integer> oldArr, ArrayList<Integer> sub)
    {
        if(start==oldArr.size()) return;
        for(int i=start; i<oldArr.size(); i++)
        {
            if(sub.isEmpty() || (sub.get(sub.size()-1) < oldArr.get(i))) // if empty i.e first run then skip otherwise only add element lexicaly greater than previous sub element
            {
                sub.add(oldArr.get(i));
                print(sub); // print subset
                lexiSubset(start+1, oldArr, sub); // move to next index
                sub.remove(start); // came back so remove last call changes
            }
        }
    }
    public static void main(String[] args) {
        new printLexiSubset(new ArrayList<Integer>(Arrays.asList(7,3,6)));
    }   
}
/**
 * Decision tree
 * first sort (3,6,7)
 * Subsets are
 * 3
 * 3 6
 * 3 6 7
 * 3 7
 * 6
 * 6 7
 * 7
 * 
 * the choice will be we will pick the element at current index and then print subset at each step itself till last index
 * 
 * 
 *           Array index[val]     i=0        i=1        i=2     end    
 * 
 *                                                       7[3,6,7]   
 *                                            6[3,6]   -------------      
 *                                                           
 *                                  3[3] -----------------------
 *                                                   
 *                                            7[3,7]   
 *                                               
 *                   -----------------------------------------------------                             
 *                                            7[6,7]        
 *                                                  
 *  start(0)c                       6[6] -----------------------    
 *                       
 *                  -----------------------------------------------------    
 * 
 *                                  7[7]
 * 
 */
