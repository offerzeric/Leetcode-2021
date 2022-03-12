package laicode.test;

import java.util.HashSet;
import java.util.Set;

/**
 * description
 *
 * @author ericzhang 2022/03/11 16:34
 */
public class RemoveCertainCharacters {
   public String remove(String input, String t) {
      // Write your solution here
      Set<Character> set = bulidSet(t);
      // [0, slow) contains valid
      // (fast, array.length) need to explore
      int slow = 0;
      char[] array = input.toCharArray();
      for(int fast = 0; fast < array.length; fast++){
         if(set.contains(array[fast])){
            continue;
         }else{
            array[slow++] = array[fast];
         }
      }
      return new String(array,0,slow);

   }
   private Set<Character> bulidSet(String t){
      Set<Character> set = new HashSet<>();
      for(int i = 0; i < t.length(); i++){
         set.add(t.charAt(i));
      }
      return set;
   }

}
