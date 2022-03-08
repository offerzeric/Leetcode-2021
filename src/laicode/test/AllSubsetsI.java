package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/06 16:20
 */
public class AllSubsetsI {
   public List<String> subSets(String set) {
      // Write your solution here.
      List<String> res = new ArrayList<>();
      if(set == null){
         return res;
      }
      if(set.length() == 0){
         res.add("");
         return res;
      }
      //every level consider an element to add or not add
      //吃吐守恒  DFS先遍历出每种情况的每个结果 再进下一种情况 深度搜索
      //BFS 递归树上是层遍历的 返回的结果不管深度 只要我cover的那几层
      //DFS递归树上是depth遍历的 每种遍历必定是到最深的那一层
      char[] array = set.toCharArray();
      int index = 0;
      StringBuilder sb = new StringBuilder();
      return subSets(array,index,sb,res);
   }

   private List<String> subSets(char[] array,int index,StringBuilder sb, List<String> list){
      if(index == array.length){
         list.add(sb.toString());
         return list;
      }
      sb.append(array[index]);
      list = subSets(array,index+1,sb,list);
      sb.deleteCharAt(sb.length() - 1);
      list = subSets(array,index+1,sb,list);
      return list;
   }
}
