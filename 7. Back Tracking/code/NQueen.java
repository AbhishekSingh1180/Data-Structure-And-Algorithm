import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NQueen {
    static int count = 0;
    NQueen(ArrayList<ArrayList<Integer>> board, int N)
    {
        solveNQueen(0, N, board);
    }
    boolean isQueenPosValid(int x, int y, ArrayList<ArrayList<Integer>> board)
    {
        int N = board.size();
        if(x==0) return true;
        else{
            //col and row check
            for(int i=0; i<N; i++)
            {
                if((board.get(i).get(y)==1) || (board.get(x).get(i)==1) ) return false;
            }
            // diagonals check
            //principal upper left - pul
            int pul = 0;
            while((x-pul)>=0 && (y+pul)<N)
            {
                if(board.get(x-pul).get(y+pul)==1) return false;
                pul++;
            }
            //principal upper right - pur
            int pur = 0;
            while((x-pur)>=0 && (y-pur)>=0)
            {
                if(board.get(x-pur).get(y-pur)==1) return false;
                pur++;
            }
            //principal lower left - pll
            int pll = 0;
            while((x+pll)<N && (y-pll)>=0)
            {
                if(board.get(x+pll).get(y-pll)==1) return false;
                pll++;
            }
            //principal lower right - plr
            int plr = 0;
            while((x+plr)<N && (y+plr)<N)
            {
                if(board.get(x+plr).get(y+plr)==1) return false;
                plr++;
            }

        }
        return true;
    }
    void solveNQueen(int start, int end, ArrayList<ArrayList<Integer>> board)
    {
        if(start==end)
        {
            System.out.println("Solution "+(++count));
            for(ArrayList<Integer> i: board)
                System.out.println(i);
            System.out.println();
            return;
        }
        for(int j=0; j<end; j++)
        {
            if(isQueenPosValid(start, j, board))
            {
                board.get(start).set(j, 1);
                solveNQueen(start+1, end, board);
                board.get(start).set(j, 0);
            }

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.close();
        ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>(N);
        for(int i=0; i<N; i++) board.add(new ArrayList<Integer>(Collections.nCopies(N, 0)));
        new NQueen(board, N);
    }
}
/*
The logic is very easy
like a chess board we need to place N queen on N X N board such that no queen can attack each other
queen move = {col , row , diagonal} i.e (| , - , X )

We will simply place each queen in each row or col. Here we will take row to place queens

                   BOARD
          -------------------------
          |  0  |  0  |  0  |  0  |   
          -------------------------
          |  0  |  0  |  0  |  0  |
          -------------------------
          |  0  |  0  |  0  |  0  |
          -------------------------
          |  0  |  0  |  0  |  0  |
          -------------------------

         Placing Q1 on board in col1 
          -------------------------
          |  1  |  X  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  0  |  0  |
          -------------------------
          |  X  |  0  |  X  |  0  |
          -------------------------
          |  X  |  0  |  0  |  X  |
          -------------------------

         Now Q1 is placed at (0,0) so now no queen can be placed at its attacking blocks (marked - X)


         Placing Q2 on board on col2 
          -------------------------
          |  1  |  X  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  2  |  0  |
          -------------------------
          |  X  |  0  |  X  |  0  |
          -------------------------
          |  X  |  0  |  0  |  X  |
          -------------------------

         Now Q2 is placed at (1,2) so now no queen can be placed at its attacking blocks too  (marked - X)


         Placing Q2 on board on col2 
          -------------------------
          |  1  |  X  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  2  |  X  |
          -------------------------
          |  X  |  X  |  X  |  X  | - COL 3 All blocked Backtrack needed
          -------------------------
          |  X  |  0  |  X  |  X  |
          -------------------------

        NOTE: Observe no queen can be placed at col3 so we will backtrack to col2 and change its queen position

         Placing Q2 on board in col2 again 
          -------------------------
          |  1  |  X  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  X  |  1  |
          -------------------------
          |  X  |  0  |  X  |  X  |
          -------------------------
          |  X  |  X  |  0  |  X  |
          -------------------------

         Placing Q3 on board in col3 again 
          -------------------------
          |  1  |  X  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  X  |  1  |
          -------------------------
          |  X  |  1  |  X  |  X  |
          -------------------------
          |  X  |  X  |  X  |  X  | - COL 3 All blocked Backtrack needed
          -------------------------

          no more pos in col3 so backtrack 
          -------------------------
          |  1  |  X  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  X  |  1  |
          -------------------------
          |  X  |  0  |  X  |  X  |
          -------------------------
          |  X  |  X  |  0  |  X  |
          -------------------------
                   
        no more pos in col2 so backtrack  
          -------------------------
          |  1  |  X  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  0  |  0  |
          -------------------------
          |  X  |  0  |  X  |  0  |
          -------------------------
          |  X  |  0  |  0  |  X  |
          -------------------------

          Placing Q1 on board in col1 
          -------------------------
          |  X  |  1  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  X  |  0  |
          -------------------------
          |  0  |  X  |  0  |  X  |
          -------------------------
          |  0  |  X  |  0  |  0  |
          -------------------------

         Placing Q2 on board in col2 
          -------------------------
          |  X  |  1  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  X  |  1  |
          -------------------------
          |  0  |  X  |  X  |  X  |
          -------------------------
          |  0  |  X  |  0  |  X  |
          -------------------------

          Placing Q3 on board in col3 
          -------------------------
          |  X  |  1  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  X  |  1  |
          -------------------------
          |  1  |  X  |  X  |  X  |
          -------------------------
          |  X  |  X  |  0  |  X  |
          -------------------------

          Placing Q4 on board in col4 
          -------------------------
          |  X  |  1  |  X  |  X  |   
          -------------------------
          |  X  |  X  |  X  |  1  |
          -------------------------
          |  1  |  X  |  X  |  X  |
          -------------------------
          |  X  |  X  |  1  |  X  |
          -------------------------

                FINAL BOARD
          -------------------------
          |  0  |  1  |  0  |  0  |   
          -------------------------
          |  0  |  0  |  0  |  1  |
          -------------------------
          |  1  |  0  |  0  |  0  |
          -------------------------
          |  0  |  0  |  1  |  0  |
          -------------------------
          Similary next solution
*/