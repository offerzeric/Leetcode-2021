package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/29 01:43
 */
public class LargestSquareOfMatches {
   public int largestSquareOfMatches(int[][] matrix) {
      // Write your solution here
      // for each node if it is 3 then right needs 2 the bottem needs 1 to get a square
      // so for every node we process the largest right and largets bottom length
      // we choose every signal length <=  min of above and check the node will satisfied
      // TC is O(m*n * (max(m,n)) + n) SC is O(m*n)
      // pre process 2 directions right and below
      // m represents the largest length of a square
      int row = matrix.length;
      int column = matrix[0].length;
      if(row == 0 || column == 0){
         return 0;
      }
      int gloMax = Integer.MIN_VALUE;
      int[][] below = new int[matrix.length][matrix[0].length];
      int[][] right = new int[matrix.length][matrix[0].length];
      int[][] m = new int[row][column];
      for(int i = 0; i < row; i++){
         m[i][column - 1] = 0;
         if(m[i][column - 1] > gloMax){
            gloMax = m[i][column - 1];
         }
      }
      for(int i = 0; i < column; i++){
         m[row - 1][i] = 0;
         if(m[row - 1][i] > gloMax){
            gloMax = m[row - 1][i];
         }
      }
      for(int i = 0; i < row; i++){
         for(int j = 0; j < column; j++){
            below[i][j] = maxLongestOneBelow(i,j,matrix);
         }
      }
      for(int i = 0; i < row; i++){
         for(int j = 0; j < column; j++){
            right[i][j] = maxLongestOneRight(i,j,matrix);
         }
      }
      for(int i = 0; i < row; i++){
         for(int j = 0; j < column; j++){
            for(int length = Math.min(below[i][j], right[i][j]);length > 0; length--){
               if(right[i+length][j] >= length && below[i][j+length] >= length ){
                  m[i][j] = length;
                  if(length > gloMax){
                     gloMax = length;
                  }
               }
            }
         }
      }
      return gloMax;
   }
   private int maxLongestOneBelow(int i, int j,int[][] matrix){
      int row = i;
      while(row < matrix.length - 1 && matrix[row][j] == 2 || matrix[row][j] == 3){
         row++;
      }
      return row - i;
   }
   private int maxLongestOneRight(int i, int j,int[][] matrix){
      int col = j;
      while(col < matrix[0].length - 1 && matrix[i][col] == 1 || matrix[i][col] == 3){
         col++;
      }
      return col - j;
   }
}
