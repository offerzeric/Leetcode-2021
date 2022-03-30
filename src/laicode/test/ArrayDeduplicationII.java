package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/03/30 00:59
 */
public class ArrayDeduplicationII {
   public int[] dedup(int[] array) {
      // Write your solution here
      // slow - 1 与 fast  差值2 如果fast和slow -1相等有三个相等 不行 fast就要往后移动
      // [0,slow] 为有效结果 fast为当前判断数字
      // 判断fast和slow-1的结果 并且把结果映射到slow+1上 此时fast这个数字已经有两个了
      if(array.length == 0){
         return array;
      }
      if(array.length == 1){
         return array;
      }
      int fast = 2;
      int slow = 1;
      while(fast < array.length){
         if(array[fast] != array[slow - 1]){
            array[++slow] = array[fast];
            fast++;
         }else{
            fast++;
         }
      }
      return Arrays.copyOf(array,slow+1);
   }
}
