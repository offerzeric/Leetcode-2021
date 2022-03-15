package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/14 17:53
 */
public class LargestSquareOf1s {
   public int largest(int[][] matrix) {
      // Write your solution here
      // since to determine a square is from 右下角的点
      // 2d dp:dp[i][j] represents the maximun square of 1s of the square of 右下角是i,j
      // base case dp[i][0] = 1; dp[0][i] = 1 dp[0][0] = 0;
      if(matrix[0].length == 1){
         if(matrix[0][0] == 1){
            return 1;
         }else{
            return 0;
         }
      }
      int m[][] = new int[matrix.length][matrix[0].length];
      int globalMax = 0;
      m[0][0] = matrix[0][0];
      for(int i = 0; i < matrix.length; i++){
         m[i][0] = matrix[i][0];
         if(m[i][0] == 1){
            globalMax = 1;
         }
      }
      for(int i = 0; i < matrix[0].length; i++){
         m[0][i] = matrix[0][i];
         if(m[0][i] == 1){
            globalMax = 1;
         }
      }
      for(int i = 1; i < matrix.length; i++){
         for(int j = 1; j < matrix[0].length; j++){
            if(matrix[i][j] == 0){
               m[i][j] = 0;
            }else{
               m[i][j] = min(m[i-1][j],m[i-1][j-1],m[i][j-1]) + 1;
               if(m[i][j] > globalMax){
                  globalMax = m[i][j];
               }
            }
         }
      }
      return globalMax;
   }
   private int min(int i, int j, int k){
      int min = Integer.MAX_VALUE;
      if(i < min){
         min = i;
      }
      if(j < min){
         min = j;
      }
      if(k < min){
         min = k;
      }
      return min;
   }
}
