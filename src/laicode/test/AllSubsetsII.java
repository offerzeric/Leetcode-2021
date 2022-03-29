package laicode.test;

import java.util.*;

/**
 * description
 *
 * @author ericzhang 2022/03/28 17:41
 */
public class AllSubsetsII {
   public List<String> subSets(String set) {
      // dfs
      // for each level we choose whether we add a char of not
      // the level number is the set length
      // base case: if the level equals the length of the set we return the cur result
      // recursion rule:  we want all the result
      // sub: we want all the result so we need start from a the cases and not start from a cases
      // TC is O(2^n) SC is O(n)
      List<String> list = new ArrayList<>();
      if(set == null){
         return list;
      }
      if(set.length() == 0){
         list.add("");
         return list;
      }
      char[] in = set.toCharArray();
      Set<String> res = new HashSet<String>();
      StringBuilder sb = new StringBuilder();
      int index = 0;
      Arrays.sort(in);
      subSets(in,res,sb,index);
      for(String item : res){
         list.add(item);
      }
      return list;
   }
   private void subSets(char[] in, Set<String> res, StringBuilder sb,int index){
      if(index == in.length){
         res.add(sb.toString());
         return;
      }
      sb.append(in[index]);
      subSets(in,res,sb,index+1);
      sb.deleteCharAt(sb.length() - 1);
      subSets(in,res,sb,index+1);
   }
}
