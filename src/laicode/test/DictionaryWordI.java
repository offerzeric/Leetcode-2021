package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/14 01:40
 */
public class DictionaryWordI {
   public boolean canBreak(String input, String[] dict) {
      // Write your solution here
      // dp: m[i] 是word的[0-i)区间内能否被dict表示 i可以到input的最后一位 cover完全不切
      // base case m[0] = true 空子集肯定是可以表示的因为dict空集不显示
      // 左大段 右小段 左边可以查表 查的是m数组不是题的表 右边直接带入题目
      // induction:
      // 1. 同一个i if [0,i） 不能被表示 切一个 检测[1,i)...切两个检测[2,i).... 有一个为true即可表示m[i]可以被dict表示
      // 2.m[in.length]就是结果
      char[] in = input.toCharArray();
      boolean[] m = new boolean[in.length + 1];
      m[0] = true;
      for(int i = 1; i < m.length; i++){
         for(int j = 0; j < i; j++){
            //如果m只有Length长度 此时判断0,1整体时会被单独0结果影响
            if(check(in,j,i,dict) && m[j]){
               m[i] = true;
               break;
            }
         }
      }
      return m[m.length - 1];
   }
   private boolean check(char[] in, int i, int j,String[] dict){
      StringBuilder sb = new StringBuilder();
      for(int k = i; k < j; k++){
         sb.append(in[k]);
      }
      for(String item : dict){
         if(sb.toString().equals(item)){
            return true;
         }
      }
      return false;
   }
}
