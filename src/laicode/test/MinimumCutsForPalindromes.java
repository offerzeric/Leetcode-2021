package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/03/20 22:15
 */
public class MinimumCutsForPalindromes {
   public static int minCuts(String input) {
      // Write your solution here
      // m[i] represents the length i string can be a palindrome witn minist how many cuts
      // induction: each time push one and ask the left and right part to dicide whether this time cut can be a palindrome
      // m[0] = 0 m[1] = 0 m[2] = 不切: 切一刀 m[3] 切一刀
      // 永远只考虑切一刀即可 因为切两刀的会cover 在之前的case中
      // TC(n^2) SC(n)
      char[] in = input.toCharArray();
      if(in.length == 0 || in.length == 1){
         return 0;
      }
      int[] m = new int[in.length + 1];
      Arrays.fill(m,Integer.MAX_VALUE);
      m[0] = 0;
      m[1] = 0;
      for(int i = 2; i <= in.length; i++){
         String item = new String(in,0,i);
         if(check(item)){
            m[i] = 0;
            continue;
         }else{
            for(int j = 1; j < i; j++){
               String temp = new String(in,j,i - j);
               if(m[j] >= 0 && m[j] < Integer.MAX_VALUE && check(temp)){
                  int res = m[j] + 1;
                  if(res < m[i]){
                     m[i] = res;
                  }
               }
            }
         }
      }
      return m[in.length];
   }
   private static boolean check(String temp){
      int i = 0;
      int j = temp.length() - 1;
      while(i <= j){
         if(temp.charAt(i) != temp.charAt(j)){
            return false;
         }
         i++;
         j--;
      }
      return true;
   }

   public static void main(String[] args) {
      String input = "aaaaaabbabb";
      int i = minCuts(input);
   }

}
