package laicode.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description
 *
 * @author ericzhang 2022/03/19 17:00
 */
public class AllAnagrams {
   public static List<Integer> allAnagrams(String sh, String lo) {
      // Write your solution here
      // find the all anagrams of sh then compare
      // TC: o(n!) + o(n)   SC:O(n)
      // each level plus one item
      // when level == sh.length means we add the word and return to next
      char[] compare = sh.toCharArray();
      char[] in = lo.toCharArray();
      int index = 0;
      StringBuilder sb = new StringBuilder();
      Set<String> set = new HashSet<>();
      getAllAnagram(compare,index, sb,set);
      List<Integer> res = new ArrayList<>();
      for(String s : set){
         for (int i = 0; i <= in.length - compare.length; i++) {
            String temp = new String(in,i,compare.length);
            if(temp.equals(s)){
               res.add(i);
            }
         }
      }
      return res;
   }

   private static void getAllAnagram(char[] compare, int index, StringBuilder sb, Set<String> res){
      if(index == compare.length - 1){
         sb.append(compare[index]);
         res.add(sb.toString());
         sb.deleteCharAt(sb.length() - 1);
         return;
      }
      for(int i = index; i < compare.length; i++){
         swap(i,index,compare);
         // index is current level to choose
         sb.append(compare[index]);
         getAllAnagram(compare,index+1,sb,res);
         sb.deleteCharAt(sb.length() - 1);
         swap(i,index,compare);
      }
   }

   private static void swap(int i, int index, char[] c){
      char temp = c[i];
      c[i] = c[index];
      c[index] = temp;
   }

   public static void main(String[] args) {
      String sh = "aab";
      String in = "ababacbbaac";
      List<Integer> integers = allAnagrams(sh, in);
   }
}
