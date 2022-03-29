package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/27 12:11
 */
public class LargestSquareSurroundedByOne {
   public int largestSquareSurroundedByOne(int[][] matrix) {
      // Write your solution here
      // 4 arrray represents four directions longest
      // induction: min[4 directions] as the largest square for this item in matrix
      // return the largest one in the item of matrix
      // 四个方向pre possess 可以两个点确定正方形(得出右下角的点后直接拿左上角坐标判断) 2个方向pre process 可以三个点确定正方形(得出右下角的点后算出其他顶点的坐标 然后用方向判断
      // 能不能形成正方形)
      // pre possess的数组代表的是正方向右下角的点能不能有最长长度
      if(matrix.length == 0 || matrix[0].length == 0){
         return 0;
      }
      int row = matrix.length;
      int column = matrix[0].length;
      int[][] up = new int[row][column];
      int[][] left = new int[row][column];
      int[][] m = new int[row][column];
      int maxLength = Integer.MIN_VALUE;
      // inital the m array
      for(int i = 0; i < row; i++){
         for(int j = 0; j < column; j++){
            left[i][j] = minLongestOnesLeft(i,j,matrix);
            up[i][j] = minLongestOnesUp(i,j,matrix);
         }
      }
      for(int i = 0; i < row; i++){
         m[i][0] = matrix[i][0];
         if(m[i][0] > maxLength){
            maxLength = m[i][0];
         }
      }
      for(int j = 0; j < column; j++){
         m[0][j] = matrix[0][j];
         if(m[0][j] > maxLength){
            maxLength = m[0][j];
         }
      }
      for(int i = 1; i < row; i++){
         for(int j = 1; j < column; j++){
            int length = Math.min(left[i][j], up[i][j]);
            for(int q = length;q >=1; q--){
               if(left[i-q+1][j] >= q && up[i][j-q+1] >= q){
                  m[i][j] = q;
                  if(m[i][j] > maxLength){
                     maxLength = m[i][j];
                  }
               }
            }
         }
      }
      return maxLength;
   }
   private int minLongestOnesLeft(int i, int j, int[][] matrix){
      int[] m = new int[j+1];
      m[0] = matrix[i][0];
      for(int k = 1; k < m.length; k++){
         if(matrix[i][k] == 1){
            m[k] = m[k-1]+1;
         }else{
            m[k] = 0;
         }
      }
      return m[j];
   }
   private int minLongestOnesUp(int i, int j, int[][] matrix){
      int[] m = new int[i+1];
      m[0] = matrix[0][j];
      for(int k = 1; k < m.length; k++){
         if(matrix[k][j] == 1){
            m[k] = m[k - 1]+1;
         }else{
            m[k] = 0;
         }
      }
      return m[i];
   }
}
