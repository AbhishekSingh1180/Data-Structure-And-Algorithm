import java.util.ArrayList;
import java.util.Arrays;
//Print all the N digit number which can formed using 1 and 2;
class Ndigitnum
{
    
    Ndigitnum(int i, int lastIndex)
    {
        ArrayList<Integer> Arr = new ArrayList<Integer>(Arrays.asList(new Integer[lastIndex])); // Arrays.asList(new Integer[lastIndex]) initial an array of size n;
        printAll(i, lastIndex, Arr);
    }
    static void printAll(int i, int lastIndex, ArrayList<Integer> Arr)
    {
        //when to stop 
        if(i==lastIndex) // at last index 
        {
            print(Arr);
            return;
        }

        //decision part

        //decision 1 set ith index as 1
        Arr.set(i,1);
        //move forward with decision 1
        printAll(i+1, lastIndex, Arr);
        //decision 2 set ith index as 2
        Arr.set(i,2);
        //move forward with decision 2
        printAll(i+1, lastIndex, Arr);
        // no. of call depends upon the no. of choices
        /**
         *  since above we only have 1 and 2 available to fill 3 places what if we can use 1-9 all digits
         *  change decision part by this
         *  for(int j=1 ; j<=9; j++)
         *  {
         *      if(i==0 && j==0)
         *      {
         *          Arr.set(i,j);
         *          printAll(i+1, lastIndex, Arr);
         *          continue;
         *      }// first position can't be zero i.e i=0 and digit 0 is not allowed j=0
         *      Arr.set(i,j);
         *      printAll(i+1,lastIndex,Arr);
         *  }
         */
    }
    static void print(ArrayList<Integer> Arr)
    {
        for(int i: Arr) System.out.print(i);
        System.out.println();
    }
    public static void main(String[] args) {
        //let N be 3 i.e all 3 digit number
        new Ndigitnum(0,3);
    }
}

/**
 * Decision tree
 *                                 i=0       i=1         i=2     end   
 * 
 *                                                       111   
 *                                            11   -------------      
 *                                                       112   
 *                                  1 -----------------------
 *                                                       121
 *                                            12   -------------
 *                                                       122
 *                      start ----------------------------------                                     
 *                                                       211   
 *                                            21   -------------      
 *                                                       212   
 *                                  2 -----------------------    
 *                                                       221
 *                                            22   -------------
 *                                                       222    
 * 
 */
