// Given N array elements check if subset sum==k;
import java.util.ArrayList;
import java.util.Arrays;

public class checkSubsetKSum {
    //static int count = 0; to check no. of calls made

    checkSubsetKSum(ArrayList<Integer> Arr, int K)
    {
        System.out.println(isSubsetSumK(0,0,K,Arr));
    }
    Boolean isSubsetSumK(int start, int sum, int K, ArrayList<Integer> Arr)
    {
        if(start == Arr.size()) return sum==K;
        //NOTE 1:  *** if(sum==K) return true; this line will further avoid check all case after the subset with sum==k is found.
        Boolean pick, notPick;

        sum+=Arr.get(start);  //picking element and adding
        pick = isSubsetSumK(start+1, sum, K, Arr);
        //count++;
        
        // NOTE 2:***** if(pick == true) return true;  this line will avoid check all case after the subset with sum==k is found.
        sum-=Arr.get(start); //not picking element and removing previous call element
        notPick = isSubsetSumK(start+1, sum, K, Arr);
        //count++;

        return ( pick || notPick );
    }
    Boolean isSubsetSumKOptimized(int start, int sum, int K, ArrayList<Integer> Arr)
    {
        if(start == Arr.size()) return sum==K;
        return (isSubsetSumK(start+1, sum+Arr.get(start), K, Arr) || isSubsetSumK(start+1, sum, K, Arr));
    }
    public static void main(String[] args) {
        new checkSubsetKSum(new ArrayList<Integer>(Arrays.asList(5,-2,9)),7);
    }
    
}
/**
 * Decision tree
 * the choice will be we will pick the element at current index or not then add to sum till last and if sum==k return true;
 * 
 * 
 *           Array index[val]     i=0(5)     i=1(-2)    i=2(9)     end    
 * 
 *                                                       12   X
 *                                            3   -------------      
 *                                                       3    X
 *                                  5 -----------------------
 *                                                       14   X
 *                                            5   -------------
 *                                                       5    X
 *                      start(0) ----------------------------------                                     
 *                                                       7    [FOUND] RETURN
 *                                            -2   -------------      
 *                                                       -2   X
 *                                  0 -----------------------    
 *                                                       9    X
 *                                            0   -------------
 *                                                       0    X
 * 
 */
