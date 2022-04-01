package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/04/01 02:28
 */
public class ArrayDeduplicationIII {
   public int[] dedup(int[] array) {
      if(array.length == 0 || array.length == 1){
         return array;
      }
      // Write your solution here
      int fast = 1;
      int slow = 0;
      boolean f = false;
      while(fast < array.length){
         if(array[slow] == array[fast]){
            f = true;
            fast++;//代替了下面while判断
         }else if(f){
            // while(fast < array.length && array[fast] == array[slow]){
            //   fast++;
            // }
            // if(fast >= array.length){
            //   fast = array.length - 1;
            // }
            array[slow] = array[fast];
            fast++;
            f = false;
         }else if(array[slow] != array[fast]){
            array[++slow] = array[fast++];
            f = false;
         }
      }
      if(!f){
         return Arrays.copyOf(array,slow+1);
      }
      return Arrays.copyOf(array,slow);
   }
}
