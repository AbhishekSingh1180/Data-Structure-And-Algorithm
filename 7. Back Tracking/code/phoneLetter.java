import java.util.ArrayList;

public class phoneLetter {

    ArrayList<String> com = new ArrayList<String>();

    static String[] phone = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // phone map

    public void letterCombinationsHelper(int start, String A, StringBuilder temp){

        if(start==A.length()){
            com.add(temp.toString());
            return;
        }

        for(Character i: phone[(int)(A.charAt(start)-'0')].toCharArray()){
            temp.append(i);
            letterCombinationsHelper(start+1, A, temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }

    public ArrayList<String> letterCombinations(String A) {
        letterCombinationsHelper(0, A, new StringBuilder());
        return com;
    }

    public static void main(String[] args) {
        phoneLetter pl = new phoneLetter();
        ArrayList<String> sol = pl.letterCombinations("23");
        for(String st : sol) System.out.println(st);
    }
}
/**
 * LOGIC :  for the give string 
 * EX:  num: "012"
 * 
 *  digit:map
 * 
 *  0: 0
 *  1: 1
 *  2: abc
 *  3: def
 *  4: ghi
 *  5: jkl
 *  6: mno
 *  7: pqrs
 *  8: tuv
 *  9: wxyz
 * 
 *  traverse the string num and for each digit pick a char from its map
 *  like for 0 in 012   0 - only choice move
 *  1 : 012   1 - only choice
 *  2 : 012   a,b,c - 3 choices
 *  012 :   [0] [1] [a]
 *          [0] [1] [b]
 *          [0] [1] [c]    
 */
