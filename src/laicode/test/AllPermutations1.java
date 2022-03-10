package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/09 16:46
 */
public class AllPermutations1 {
   public List<String> permutations(String input) {
      // Write your solution here
      List<String> list = new ArrayList<>();
      if(input.length() == 0){
         list.add("");
         return list;
      }
      char[] array = input.toCharArray();
      int index = 0;
      int level = 1;
      StringBuilder sb = new StringBuilder();
      permutations(array,index,level,list,sb);
      return list;
   }
   /*
      先取出第一种可能性的所有结果 再取出第一种下第二个位置的可能结果......
      swap-swap  ->  [0,index)是已经固定的不能再换位置的部分  [index,array.length - 1] 是可以更换成不同情况的部分
      有吃就要吐
      swap大法： 如果要你求的结果 是permutation的一部分 或者其中一种，往swap方向想
    */
   private void permutations(char[] array,int index, int level, List<String> list,StringBuilder sb){
      if(level == array.length){
         sb.append(array[index]);
         list.add(sb.toString());
         sb.deleteCharAt(sb.length() - 1);
         return;
      }
      for(int i = index; i < array.length; i++){
         swap(array, index, i);
         sb.append(array[index]);
         permutations(array,index+1,level+1,list,sb);
         sb.deleteCharAt(sb.length() - 1);
         swap(array, index, i);
      }
   }
   private void swap(char[] array, int index, int i){
      char temp = array[index];
      array[index] = array[i];
      array[i] = temp;
   }
}
//			abc
//
//               a         b        c
//               /    \       /  \      /   \
//               b      c    a    c  a    b
//               | 	    |    |      |   |     |
//               c        b   c     a  b    a