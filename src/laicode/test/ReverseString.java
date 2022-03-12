package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/12 01:23
 */
public class ReverseString {
   public String reverse(String input) {
      // Write your solution here
      int i = 0;
      int j = input.length() - 1;
      char[] array = input.toCharArray();
      while(i < j){
         char temp = array[i];
         array[i] = array[j];
         array[j] = temp;
         i++;
         j--;
      }
      return new String(array);
   }
}
