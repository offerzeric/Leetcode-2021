package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/12 19:19
 */
public class ClosestInSortedArray {

   public int closest(int[] array, int target) {
      // Write your solution here
      if (array == null || array.length == 0) {
         return -1;
      }
      int start = 0;
      int end = array.length - 1;
      //如果有target值直接返回 如果找不到target进行比较
      while (start < end - 1) {
         int mid = start + (end - start) / 2;
         if (array[mid] > target) {
            end = mid;
         } else if (array[mid] < target) {
            start = mid;
         } else {
            return mid;
         }
      }
      if (Math.abs(target - array[start]) < Math.abs(array[end] - target)) {
         return start;
      } else {
         return end;
      }
   }

}
