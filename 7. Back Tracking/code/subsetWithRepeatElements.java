import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class subsetWithRepeatElements {
    HashSet<ArrayList<Integer>> sub = new HashSet<ArrayList<Integer>>(); // to remove duplicate subset
    subsetWithRepeatElements(ArrayList<Integer> A)
    {
        Collections.sort(A);
        subset(0,A,new ArrayList<Integer>());
        ArrayList<ArrayList<Integer>> uniSub = sortAndAddNull(sub);
        print(uniSub);
    }
    void print(ArrayList<ArrayList<Integer>> ArrayList)
    {
        for(ArrayList<Integer> i: ArrayList)
        {
            System.out.println(i);
        }
    }
    ArrayList<ArrayList<Integer>> sortAndAddNull(HashSet<ArrayList<Integer>> sub)
    {
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(sub);
        Collections.sort(list, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> X, ArrayList<Integer> Y)
            {
                int size = Math.min(X.size(), Y.size());
                for(int i=0; i<size; i++)
                {
                    int cmp = Integer.compare(X.get(i), Y.get(i));
                    if(cmp!=0) return cmp;
                }
                return Integer.compare(X.size(),Y.size());
            }
        });
        list.add(0,new ArrayList<Integer>()); // adding the remaining empty set
        return new ArrayList<ArrayList<Integer>>(list); 
         
    }
    void subset(int start, ArrayList<Integer> A, ArrayList<Integer> B)
    {
        if(start==A.size()) return;
        for(int i=start; i<A.size(); i++)
        {
            B.add(A.get(i)); 
            sub.add(new ArrayList<Integer>(B));
            subset(i+1, A, B);
            B.remove(A.get(i));
        }
    }
    public static void main(String[] args) {
        new subsetWithRepeatElements(new ArrayList<Integer>(Arrays.asList(1,2,2)));
    }
}
/**
 * Decision tree
 * the choice will be we will pick the element at current index or not then add subset to hashset(no duplicate) till last return true;

 * Decision tree
 * first sort (1,2,2)
 * Subsets are
 * []
 * [1]
 * [1 2]
 * [1 2 2]
 * [2] 
 * [2 2]
 * 
 * the choice will be we will pick the element at current index and then add subset to hashset at each step itself till last index
 * 
 * 
 *           Array index[val]      i=0        i=1        i=2     end    
 * 
 *                                                       2[1,2,2]   
 *                                            2[1,2]   -------------      
 *                                                           
 *                                  1[1] -----------------------
 *                                                   
 *                                            2[1,2]  X - Not added repeating
 *                                               
 *                   -----------------------------------------------------                             
 *                                            2[2,2]        
 *                                                  
 *  start(0)                        2[2] -----------------------    
 *                       
 *                  -----------------------------------------------------    
 * 
 *                                  2[2] X - not added repeating
 * finally sort;
 */