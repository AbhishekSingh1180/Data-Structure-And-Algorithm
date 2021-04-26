//Given all +ve array elements an element can be picked any no. of times find the no. subset sum == k.
import java.util.ArrayList;
import java.util.Arrays;

public class repeatSubsetKSum {
    repeatSubsetKSum(ArrayList<Integer> Arr, int K)
    {
        System.out.println(numSubsetSumK(0,0,K,Arr));
    }
    int numSubsetSumK(int start, int sum, int K, ArrayList<Integer> Arr)
    {
        if(sum>K) return 0;
        if(sum==K) return 1;
        if(start==Arr.size()) return (sum==K)?1:0;

        return numSubsetSumK(start+1, sum, K, Arr) // skip it
                + numSubsetSumK(start, sum+Arr.get(start), K, Arr); // stay at it
    }
    public static void main(String[] args) {
        new repeatSubsetKSum(new ArrayList<Integer>(Arrays.asList(1,3,5)),6);
    }   
}
/**
 * the subproblem is either we stay with the element and sum it or skip it.
 * Decision tree                        
 * format: element(sum upto)                                                    
 *                                                                                                             1(6) == Found 
 * 
 *                                                                                             1(5)------------   
 *                                                                                                             3(8) X
 * 
 *                                                                                       
 *                                                                              1(4)-----------        
 *                                                                                                                             
 *                                                                                             3(7) X
 *                                                                    
 *                                                                  1(3)------------                 
 *                                        
 *                                                                              3(6) == Found     
 *                                            
 *                                                            1(2)---------------------     
 *                      
 *                                                                              3(8) X                                                        
 *                                  
 *                                                                   3(5)-----------
 *                                                              
 *                                                                              5(10) X                                                        
 *  
 *                              
 * 
 * 
 *                                                                  3(7) X
 * 
 *                              1(1)-------------------------3(4)----------
 *                                            
 *                                                                  5(9) X
 *       
 *                                            5(6) == Found
 *                                          
 *                                                       
 *          --------------------------------------------------------------------------------------------------------                                            
 *   
 *                                             3(6) == Found
 *  
 * 
 * 
 *start(0)  -----------------   3(3) -------------
 *      
 *                                             
 *                                             5(8) X
 * 
 * 
 *          ----------------------------------------------------------------------------------------------------------
 * 
 *                                             5(5) X
 *                                                  
 *  
 *                              5(5) --------------
 *                  
 * 
 *                                             No element left
 *                                             
 */
