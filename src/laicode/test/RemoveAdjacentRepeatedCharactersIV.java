package laicode.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * description
 *
 * @author ericzhang 2022/03/11 22:40
 */
public class RemoveAdjacentRepeatedCharactersIV {

   public String deDup(String input) {
      // Write your solution here
      //[0,slow) is ok [fast, array.length) is to explore
      // use stack to save the duplicate item cuz we need to remember every show up a item in case they need to be processed
      char[] array = input.toCharArray();
      int fast = 0;
      Deque<Character> stack = new ArrayDeque<>();
      while (fast < array.length) {
         char cur = array[fast];
         if (!stack.isEmpty() && stack.peekFirst() == cur) {
            while (fast < array.length && array[fast] == cur) {
               fast++;
            }
            stack.pollFirst();
         } else {
            stack.offerFirst(array[fast]);
            fast++;
         }
      }
      int len = stack.size();
      for (int i = len - 1; i >= 0; i--) {
         array[i] = stack.pollFirst();
      }
      return new String(array, 0, len);
   }
}
