package laicode.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description
 *
 * @author ericzhang 2022/03/18 00:04
 */
public class LongestSubstringWithoutRepeatingCharacters {
   public int longest(String input) {
      // Write your solution here
      // two pointers
      int slow = 0;
      char[] in = input.toCharArray();
      int length = 0;
      int glo = 0;
      int fast = 0;
      HashSet<Character> set = new HashSet<>();
      while(fast < in.length){
         if(!set.contains(in[fast])){
            set.add(in[fast]);
            length = fast - slow + 1;
            if(length > glo){
               glo = length;
            }
            fast++;
         }else{
            set.remove(in[slow]);
            slow++;
         }
      }
      return glo;
   }
}
