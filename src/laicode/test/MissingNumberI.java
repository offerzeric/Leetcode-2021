package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/03/11 16:05
 */
public class MissingNumberI {
   public int missing(int[] array) {
      // Write your solution here
      Arrays.sort(array);
      for(int i = 1; i <= array.length + 1; i++){
         if(!binarySearch(i,array)){
            return i;
         }
      }
      return 1;
   }

   private boolean binarySearch(int target, int[] array){
      int left = 0;
      int right = array.length - 1;
      int mid = -1;
      while(left <= right){
         mid = left + (right - left) / 2;
         if(array[mid] == target){
            return true;
         }else if(array[mid] < target){
            left = mid + 1;
         }else{
            right = mid - 1;
         }
      }
      return false;
   }
}
