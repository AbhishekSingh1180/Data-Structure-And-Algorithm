import java.util.ArrayList;
import java.util.Arrays;

public class Suduko {
    Suduko(ArrayList<ArrayList<Integer>> Board)
    {
        solveSuduko(0, Board);   
    }
    boolean isValidPos(int i, int j, int num, ArrayList<ArrayList<Integer>> Board)
    {
        //check row
        for(int r = 0; r < 9; r++) if(Board.get(r).get(j)==num) return false;

        //check col
        for(int c = 0; c < 9; c++) if(Board.get(i).get(c)==num) return false;

        //check block
        int x = (i-(i%3)); //blockStartIndex x
        int y = (j-(j%3)); //blockStartIndex y

        int m = 3;
        while((m--)>0)
        {
            if(Board.get(x).get(y)==num || Board.get(x).get(y+1)==num || Board.get(x).get(y+1)==num) return false;
            x++;
        }
        return true;
    }
    Boolean solveSuduko(int index, ArrayList<ArrayList<Integer>> Board)
    {
        if(index==81) 
        {
            System.out.println("Soduko Solved!!");
            for(ArrayList<Integer> i: Board)
            {
                System.out.println(i);
            }
            return true;
        }
        int i = index/9, j = index%9;
        if(Board.get(i).get(j)!=0)
        {
            return solveSuduko(index+1, Board);   
        }
        boolean isSolved = false;
        for(int num = 1; num <= 9 ; num++)
        {
            if(isValidPos(i, j, num, Board))
            {
                Board.get(i).set(j, num);
                isSolved = solveSuduko(index+1, Board);
                if(isSolved) return true;
                Board.get(i).set(j, 0);               
            }
        }
        return isSolved; 
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> Board = new ArrayList<ArrayList<Integer>>();
        Board.add(new ArrayList<Integer>(Arrays.asList(4,0,0,0,8,6,7,0,0)));
        Board.add(new ArrayList<Integer>(Arrays.asList(6,2,0,0,1,0,0,9,0)));
        Board.add(new ArrayList<Integer>(Arrays.asList(0,7,0,3,5,2,0,0,0)));
        Board.add(new ArrayList<Integer>(Arrays.asList(0,4,0,5,0,0,9,0,7)));
        Board.add(new ArrayList<Integer>(Arrays.asList(0,0,7,0,0,0,1,0,0)));
        Board.add(new ArrayList<Integer>(Arrays.asList(1,0,9,0,0,3,0,5,0)));
        Board.add(new ArrayList<Integer>(Arrays.asList(0,0,0,8,2,5,0,6,0)));
        Board.add(new ArrayList<Integer>(Arrays.asList(0,9,0,0,7,0,0,8,1)));
        Board.add(new ArrayList<Integer>(Arrays.asList(0,0,6,1,3,0,0,0,2)));
        System.out.println("Soduko Board Puzzle");
        for(ArrayList<Integer> i: Board)
        {
            System.out.println(i);
        }
        System.out.println();
        new Suduko(Board);
    }
}
/**
 *                             SUDOKO BOARD
          =======================================================
          |  4  |     |     |     |  8  |  6  |  7  |     |     |
          |-----------------|-----------------|-----------------|
          |  6  |  2  |     |     |  1  |     |     |  9  |     |
          |-----------------|-----------------|-----------------|
          |     |  7  |     |  3  |  5  |  2  |     |     |     |
          =======================================================
          |     |  4  |     |  5  |     |     |  9  |     |  7  |
          |-----------------|-----------------|-----------------|
          |     |     |  7  |     |     |     |  1  |     |     |
          |-----------------|-----------------|-----------------|
          |  1  |     |  9  |     |     |  3  |     |  5  |     |
          =======================================================
          |     |     |     |  8  |  2  |  5  |     |  6  |     |
          |-----------------|-----------------|-----------------|
          |     |  9  |     |     |  7  |     |     |  8  |  1  |
          |-----------------|-----------------|-----------------|
          |     |     |  6  |  1  |  3  |     |     |     |  2  |
          =======================================================

          Now it's a 9 X 9 sudoko having 81 indexes so we will address index by 1D form like  (2,5) in 2D  =  2*9 + 5 = 23 in 1D
          or 23 = (23/9,23%9)  i.e  int index = (index/N , index%N)

          so basic backtracking travel from 1 - 81 an at each index that is empty put any number bw 1 - 9 following sudoko rules
 */
