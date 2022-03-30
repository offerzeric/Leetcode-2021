package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/03/29 23:32
 */
public class ArrayDeduplicationI {
   public int[] dedup(int[] array) {
      if(array.length == 0){
         return array;
      }
      if(array.length == 1){
         return array;
      }
      // Write your solution here
      int slow = 0;
      int fast = 1;
      while(fast < array.length){
         if(array[fast] != array[slow]){
            array[++slow] = array[fast];
            fast++;
         }else{
            while(fast < array.length && array[fast] == array[slow]){
               fast++;
            }
         }
      }
      return Arrays.copyOf(array,slow+1);
   }
}
