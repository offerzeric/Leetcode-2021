package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/16 11:44
 */
public class SpiralOrderTraverseII {
   public List<Integer> spiral(int[][] matrix) {
      // Write your solution here
      // base case: if remain == 0 or
      // sub problem: for each out cycle we need print one time
      // iterative rule print every cycle then add to list
      // TC o(m*n) sc: o(1)
      int left = 0;
      int up = 0;
      int down = matrix.length - 1;
      int right = matrix[0].length - 1;
      List<Integer> list = new ArrayList<Integer>();
      while (left < right && up < down) {
         for (int i = left; i < right; i++) {
            list.add(matrix[up][i]);
         }
         for (int i = up; i < down; i++) {
            list.add(matrix[i][right]);
         }
         for (int i = right; i > left; i--) {
            list.add(matrix[down][i]);
         }
         for (int i = down; i > up; i--) {
            list.add(matrix[i][left]);
         }
         left++;
         right--;
         up++;
         down--;
      }
      if (left > right || up > down) {
         return list;
      }
      if (left == right) {
         for (int i = up; i <= down; i++) {
            list.add(matrix[i][left]);
         }
      } else {
         for (int i = left; i <= right; i++) {
            list.add(matrix[up][i]);
         }
      }
      return list;
   }
}
