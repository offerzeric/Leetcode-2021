package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/12 19:48
 */
public class SearchInSortedMatrixI {

   public static void main(String[] args) {
      int[][] ints = {{1, 2, 3, 4}};
      int target = 4;
      search(ints,target);
   }
      public static int[] search(int[][] matrix, int target) {
         // Write your solution here
         if (matrix == null || matrix[0].length == 0) {
            return new int[]{-1, -1};
         }
         int row = matrix.length;
         int col = matrix[0].length;
         int i = 0;
         int j = row * col - 1;
         while (i <= j) {
            int mid = i + (j - i) / 2;
            int left = mid / col;
            int right = mid % col;
            if (matrix[left][right] < target) {
               i = mid + 1;
            } else if (matrix[left][right] > target) {
               j = mid - 1;
            } else {
               return new int[]{left, right};
            }
         }
         return new int[]{-1, -1};
      }
}
