import java.util.ArrayList;
import java.util.Arrays;
class countPathMatrix {
    countPathMatrix(ArrayList<ArrayList<Integer>> matrix)
    {
        int x = -1, y =-1; // start cordinates ini
        int zCnt = 0;
        for(int i=0; i<matrix.size(); i++)
        {
            for(int j=0; j<matrix.get(0).size(); j++)
            {
                if( matrix.get(i).get(j)==1 )  //find start points 
                {
                    x = i;
                    y = j;
                }
                if( matrix.get(i).get(j)==0 )  // get zero counts for absolute path search
                {
                    zCnt++;
                }
            }
        }
        System.out.println(countPAth(x, y, matrix));
        System.out.println(countPAthAbsolute(x, y, zCnt, matrix));

    }
    int countPAth(int i, int j, ArrayList<ArrayList<Integer>> matrix)
    {
        if( i<0 || i>=matrix.size() || j<0 || j>=matrix.get(0).size() || matrix.get(i).get(j)==-1) return 0;
        if( matrix.get(i).get(j)==2) return 1;
        int cnt = 0;
        matrix.get(i).set(j,-1);
        cnt += countPAth(i+1, j, matrix); //down
        cnt += countPAth(i-1, j, matrix); //up
        cnt += countPAth(i, j+1, matrix); //right
        cnt += countPAth(i, j-1, matrix); //left
        matrix.get(i).set(j,0);
        return cnt;
    }

    int countPAthAbsolute(int i, int j, int zCnt, ArrayList<ArrayList<Integer>> matrix)
    {
        if( i<0 || i>=matrix.size() || j<0 || j>=matrix.get(0).size() || matrix.get(i).get(j)==-1) return 0;
        if( matrix.get(i).get(j)==2) 
        {
            return (zCnt==-1)?1:0; 
        }
        int cnt = 0;
        matrix.get(i).set(j,-1);
        cnt += countPAthAbsolute(i+1, j, zCnt-1, matrix); //down
        cnt += countPAthAbsolute(i-1, j, zCnt-1, matrix); //up
        cnt += countPAthAbsolute(i, j+1, zCnt-1, matrix); //right
        cnt += countPAthAbsolute(i, j-1, zCnt-1, matrix); //left
        matrix.get(i).set(j,0);
        return cnt;
    }

    public static void main(String[] args) {
        // //All path no overlaping allowed
        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<ArrayList<Integer>>();
        matrix1.add(new ArrayList<Integer>(Arrays.asList(0,-1,-1,-1,-1)));
        matrix1.add(new ArrayList<Integer>(Arrays.asList(-1,0,0,2,0)));
        matrix1.add(new ArrayList<Integer>(Arrays.asList(-1,0,0,0,0)));
        matrix1.add(new ArrayList<Integer>(Arrays.asList(-1,1,0,-1,-1)));
        matrix1.add(new ArrayList<Integer>(Arrays.asList(-1,0,0,0,0)));

        new countPathMatrix(matrix1);

        //Absolute zero covering path i.e All zero to be covered before reaching the end no overlaping allowed
        

        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<ArrayList<Integer>>();
        matrix2.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0)));
        matrix2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
        matrix2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 2, -1)));

        new countPathMatrix(matrix2);
    }
}
/**
 *    LOGIC
 * 
 *    we know that at each step of backtracking we have to make decisions i.e next subproblem
 * 
 *    now 1 - start
 *        0 - path
 *       -1 - obstacle
 *        2 - end
 * 
 *    we will start from 1 (0,0) in matrix2 to cover both concept absolute path and all path 
 *    since matrix1 doesn't have absolute path
 * 
 *                 MATRIX 2
 *         -------------------------
 *         |  1  |  0  |  0  |  0  |   
 *         -------------------------
 *         |  0  |  0  |  0  |  0  |
 *         -------------------------
 *         |  0  |  0  |  2  | -1  |
 *         -------------------------
 *     We have the following two absolute paths covering all zeros: 
 *     1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 *     2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)s
 * 
 *     Now at any point in path say (i,j) we have 4 choices
 *     1.  UP     (i-1, j)
 *     2.  DOWN   (i+1, j)
 *     3.  RIGHT  (i ,j+1)
 *     4.  LEFT   (i ,j-1)
 * 
 *      At each choice new possiblities open hence cnt all
 *      stop at only boundary condition or matrix[i][j] = 2 (destination)
 
 */