package laicode.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * description
 *
 * @author ericzhang 2022/03/11 17:33
 */
public class RemoveAdjacentRepeatedCharactersI {
   public String deDup(String input) {
      // Write your solution here
      if(input == null){
         return null;
      }
      return buildSet(input);
   }
   private String buildSet(String input){
      Set<Character> set = new HashSet<>();
      String res = "";
      char[] array = input.toCharArray();
      for(int i = 0; i < array.length; i++){
         set.add(array[i]);
      }
      Iterator it = set.iterator();
      while(it.hasNext()){
         res+=it.next();
      }
      return res;
   }
}
