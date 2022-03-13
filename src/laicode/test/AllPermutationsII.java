package laicode.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description
 *
 * @author ericzhang 2022/03/13 00:51
 */
public class AllPermutationsII {
   public List<String> permutations(String input) {
      // Write your solution here
      List<String> list = new ArrayList<>();
      if(input.length() == 0){
         list.add("");
         return list;
      }
      if(input == null){
         return list;
      }
      //each level choose a item
      //level = input.length
      //base rule: when level is right => plus the last and add to list
      //sub choose one word and determine the left words all permutations to become a result
      //recursion rule:return the list
      int level = 1;
      int index = 0;
      char[] array = input.toCharArray();
      StringBuilder sb = new StringBuilder();
      Set<String> set = new HashSet<>();
      permutations(array, index, level, sb, set);
      for(String s : set){
         list.add(s);
      }
      return list;
   }

   private void permutations(char[] array,int index, int level, StringBuilder sb, Set<String> set){

      if(level == array.length){
         sb.append(array[index]);
         set.add(sb.toString());
         sb.deleteCharAt(sb.length() - 1);
         return;
      }
      for(int i = index; i < array.length;i++){
         swap(array,index,i);
         sb.append(array[index]);
         permutations(array,index+1,level+1,sb,set);
         sb.deleteCharAt(sb.length() - 1);
         swap(array,index,i);
      }
   }
   private void swap(char[] array, int index, int i){
      char temp = array[index];
      array[index] = array[i];
      array[i] = temp;
   }
}
