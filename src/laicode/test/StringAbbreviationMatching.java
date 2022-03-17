package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/16 16:28
 */
public class StringAbbreviationMatching {
   public boolean match(String input, String pattern) {
      // Write your solution here
      // base : 一起出去是唯一正解
      // sub:整个都对 每个部分都要对
      // recursion 每个部分都对整个对
      // TC: o(j)  sco(i + j)
      if(pattern.length() > input.length()){
         return false;
      }
      int j = 0;
      int i = 0;
      char[] in = input.toCharArray();
      char[] pa = pattern.toCharArray();
      return match(i,j,in,pa);
   }
   private boolean match(int i, int j, char[] in, char[] pa){
      if(j == pa.length && i == in.length){
         return true;
      }
      if(in.length  <= i || pa.length <= j){
         return false;
      }

      if(pa[j] - '0' <= 9 && pa[j] - '0' >= 0){
         int count = 0;
         while(j < pa.length && pa[j] - '0' >= 0 && pa[j] - '0' <= 9){
            count = 10*count + (pa[j] - '0');
            j++;
         }
         i += count;
      }else{
         if(pa[j] == in[i]){
            i++;
            j++;
         }else{
            return false;
         }
      }
      return match(i,j,in,pa);
   }
}
