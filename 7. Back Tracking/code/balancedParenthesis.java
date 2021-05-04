//Given N print all the balanced Parenthesis of length 2N
import java.util.ArrayList;
public class balancedParenthesis {
    balancedParenthesis(ArrayList<Character> Arr,int N)
    {
        int countClose = 0, countOpen = 0;
        for(int i=0; i<2*N; i++) Arr.add('x'); // assign character array some default value
        printall(0, N, countOpen, countClose, Arr);
    }
    void printall(int start, int end, int cO, int cC ,ArrayList<Character> Arr)
    {
        if(start==(end*2)) // break conditions
        {
            print(Arr);
            return;
        }
        //2 subproblem either pick open["("] or close[")"]
        if(cO<end) // we can only add open upto N ex. 3  "(((" )))
        {
            Arr.set(start,'(');
            printall(start+1, end, cO+1, cC, Arr);
        }
        if(cO>cC) // close can be added if it's count is less then open brakets
        {
            Arr.set(start,')');
            printall(start+1, end, cO, cC+1, Arr);
        }
    }
    void print(ArrayList<Character> Arr)
    {
        for(Character i:Arr)
        {
            System.out.print(i);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int N = 3;
        new balancedParenthesis(new ArrayList<Character>(2*N),N);
    }   
}

/**
 * Decision tree 
 * length of parenthesis will be 2N bcz no.of open = no. of close i.e 2N
 * 
 * let N=3 total length will be 6
 * means open bracket can be upto 3 and close upto 3
 * at any point close can't exceed open  n['(']>n[')']
 * and  n['(']< N
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 * 
 * 
 *                                 i=0       i=1         i=2        i=3         i=4         i=5         PRINT
 * 
 * 
 * 
 *         
 *                                                                  
 *                                                       (3 break      )1       )2          )3  ------> ((()))
 * 
 * 
 *                                            (2   -------------------------------------------     
 *  
 *                                                                  (3 break    )2          )3  ------> (()())
 * 
 * 
 *                                                       )1     ------------------------------
 *                                                                  
 *                                                                              (3 break    )3  ------> (())()
 *                                                                  )2------------------------
 *                                                                              )3 exceed open [X] ---> Invalid
 * 
 *                                  (1 -------------------------------------------------------
 * 
 *                                                                                
 *                                                                 (3 break     )2         )3  ------>  ()(())
 * 
 * 
 *                                                       (2  -------------------------------
 * 
 *                                                                             (3 break    )3  ------>  ()()()
 *                                                                 )2  ---------------------
 *                                                                             ) exceed open [X] ---> Invalid
 *                                            )1   -------------------------------------------
 *                                                       )2 exceed open [X] ------------------------> Invalid
 *                    start ----------------------------------------------------------------------------------                                     
 *                                            
 * 
 * 
 *                                  ) [X] first place can't be close 
 *              
 * 
 */