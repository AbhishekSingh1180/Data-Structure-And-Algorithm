import java.util.ArrayList;
import java.util.Arrays;
public class noOfWayStrFormFromSet 
{
    noOfWayStrFormFromSet (String str,ArrayList<String> set)
    {
        int count = strPos(0, str, set);
        System.out.println(count);
    }
    int strPos(int start, String str, ArrayList<String> set)
    {
        if(start==str.length()) return 1;
        int local_count = 0;
        for(int i=start; i<str.length(); i++)
        {
            if(set.contains(str.substring(start, i+1)))
            {
                local_count += strPos(i+1,str, set);
            }
        }   
        return local_count;
    }   
    public static void main(String[] args) {
        new noOfWayStrFormFromSet (new String("InterviewBit"),
                   new ArrayList<String>(
                       Arrays.asList("Int","Bit","view","Interview","In","ter","Bi","t","er","erview")
                                         )
                   );
    }
}
/**
 * logic
 * start by str first letter and check if it's in set or not increment 
 * and add one more to check if found then check the remaining part again
 * 
 *    C1   I ***** 0
 *    C2   In - [terviewBit]
 *              t - [erviewBit]
 *                  e ***** 0
 *                  er - [viewBit]
 *                       v ***** 0 
 *                       vi ***** 0
 *                       vie ***** 0
 *                       view - [Bit]
 *                              B *****
 *                              Bi - [t]
 *                                   t ====== 1
 *                              Bit ====== 2
 *                       viewB *****
 *                       viewBi *****
 *                       viewBit *****
 *                   erv *****
 *                   ervi *****
 *                   ervie *****
 *                   erview - [Bit]
 *                            B *****
 *                            Bi - [t]
 *                                   t ====== 3
 *                            Bit ====== 4
 *                   erviewB *****
 *                   erviewBi *****
 *                   erviewBit *****
 *               te *****
 *               ter - [viewBit]
 *                     v ***** 0 
 *                     vi ***** 0
 *                     vie ***** 0
 *                     view - [Bit]
 *                            B *****
 *                            Bi - [t]
 *                                 t ====== 5
 *                            Bit ====== 6
 *                     viewB *****
 *                     viewBi *****
 *                     viewBit *****
 *                terv *****
 *                tervi *****
 *                tervie *****
 *                terview *****
 *                terviewB *****
 *                terviewBi *****
 *                terviewBit *****
 *         Int - [erviewBit]
 *               e ***** 0
 *               er - [viewBit]
 *                    v ***** 0 
 *                    vi ***** 0
 *                    vie ***** 0
 *                    view - [Bit]
 *                           B *****
 *                           Bi - [t]
 *                                t ====== 7
 *                           Bit ====== 8
 *                    viewB *****
 *                    viewBi *****
 *                    viewBit *****
 *                erv *****
 *                ervi *****
 *                ervie *****
 *                erview - [Bit]
 *                         B *****
 *                         Bi - [t]
 *                              t ====== 9
 *                         Bit ====== 10
 *                erviewB *****
 *                erviewBi *****
 *                erviewBit *****
 *         Inte *****
 *         Inter *****
 *         Interv *****
 *         Intervi *****
 *         Intervie *****
 *         Interview - [Bit]
 *                     B *****
 *                     Bi - [t]
 *                          t ====== 11
 *                     Bit ====== 12
 *         InterviewB *****
 *         InterviewBi *****
 *         InterviewBit *****
 *  -------- END ----------
 * 
 * Observe that many call are repeating like [Bit],[viewBit] and hence taking extra time to save such call time we
 * store the result and directly call the stored result rather than applying function call again
 * this is know as dp or dynamic Programming           
 */
