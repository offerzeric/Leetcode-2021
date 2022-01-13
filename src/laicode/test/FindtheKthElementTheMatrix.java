package laicode.test;

/**
 * 2d矩阵转换为array  第一位  坐标/row  第二位  坐标%col
 *
 * @author ericzhang 2022/01/12 19:31
 */
public class FindtheKthElementTheMatrix {

   public int findElement(int[][] matrix, int k) {
      // Write your solution here
      if (matrix == null || matrix.length == 0) {
         return -1;
      }
      int row = matrix.length;
      int col = matrix[0].length;
      return matrix[k / col][k % col];
   }


}
