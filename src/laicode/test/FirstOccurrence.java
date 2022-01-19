package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/01/12 19:20
 */
public class FirstOccurrence {

   public int firstOccur(int[] array, int target) {
      // Write your solution here
      if (array == null || array.length == 0) {
         return -1;
      }
      int start = 0;
      int end = array.length - 1;
      //start <= end 是做binary search时进行单个元素查找的条件
      //start < end-1是查范围的时候用的查找条件
      while (start < end - 1) {
         int mid = start + (end - start) / 2;
         if (array[mid] < target) {
            start = mid + 1;
         } else if (array[mid] > target) {
            end = mid - 1;
         } else {
            end = mid;
         }
      }
      if (array[start] == target) {
         return start;
      }
      if (array[end] == target) {
         return end;
      }
      return -1;
   }


}
