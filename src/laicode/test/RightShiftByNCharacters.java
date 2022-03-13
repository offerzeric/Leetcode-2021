package laicode.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * description
 *
 * @author ericzhang 2022/03/12 14:12
 */
public class RightShiftByNCharacters {
   public String rightShift(String input, int n) {
      // Write your solution here
      // just same as the reverse i love yahoo
      if(input.length() == 0){
         return input;
      }
      char[] array = input.toCharArray();
      int times = n % array.length;
      for(int k = 0; k < times; k++){
         reverse(array);
      }
      return new String(array);
   }
   private void reverse(char[] array){
      //顺延 交换
      Queue<Character> queue = new ArrayDeque<>();
      char item = array[array.length - 1];
      for(int i = 0; i < array.length - 1; i++){
         queue.offer(array[i]);
      }
      for(int i = 1; i < array.length; i++){
         array[i] = queue.poll();
      }
      array[0] = item;
   }
}
