import java.util.ArrayList;
import java.util.Arrays;
class InterestingArray
{
    InterestingArray(ArrayList<Integer> A)
    {
        int oddcnt = 0;
        for(Integer i:A) if((i&1)==1) oddcnt++;
        System.out.print(((oddcnt&1)==1)?"No":"Yes");
    }
    public static void main(String[] args) {
        new InterestingArray(new ArrayList<Integer>(Arrays.asList(19,17)));
    }
}