package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/28 17:57
 */
public class AllSubsetsofSizeK {
   public List<String> subSetsOfSizeK(String set, int k) {
      // Write your solution here
      // dfs
      // each level we add or not
      // base case if index = set.length we return
      // recursion rule: all the result
      // sub same
      // TC(o2^n) SC(o n)
      List<String> list = new ArrayList<>();
      if(set == null){
         return list;
      }
      if(set.length() == 0){
         list.add("");
         return list;
      }

      StringBuilder sb = new StringBuilder();
      char[] in = set.toCharArray();
      int index = 0;
      subSets(list,sb,index,k,in);
      return list;
   }
   private void subSets(List<String> list, StringBuilder sb, int index, int k,char[] in){
      if(index == in.length && sb.length() == k){
         list.add(sb.toString());
         return;
      }else if(index == in.length){
         return;
      }
      sb.append(in[index]);
      subSets(list,sb,index+1,k,in);
      sb.deleteCharAt(sb.length()-1);
      subSets(list,sb,index+1,k,in);
   }
}
