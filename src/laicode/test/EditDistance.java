package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/14 14:57
 */
public class EditDistance {
   public int editDistance(String one, String two) {
      // Write your solution here
      // 2d : always transfer to m[i-1][j] m[i-1][j-1] m[i][j-1](insert)  must use 2d array cuz use one d will not satisfize the physicl meaning of m[i]
      // dp: m[i][j] represents the min number of 三兄弟 去操作形成相等string for size in i and j
      // base case: m[0][0] = 0 m[0][j] = j  m[i][0] = i
      // induction: choose three method each time determine the min number use of them + 1
      // three condtions  tc o(m or n) sc o(m*n) 回头看一个就可以了 可以优化sc为o(1)
      if(one.length() == 0){
         return two.length();
      }
      if(two.length() == 0){
         return one.length();
      }
      int[][] m = new int[one.length()+1][two.length()+1];
      int i = one.length();
      int j = two.length();
      m[0][0] = 0;
      m[0][j] = j;
      m[i][0] = i;
      char[] onec = one.toCharArray();
      char[] twoc = two.toCharArray();
      for(int q = 1; q <= j; q++){
         m[0][q] = q;
      }
      for(int k = 1; k <= i; k++){
         m[k][0] = k;
      }
      for(int k = 1;k <= i; k++){
         for(int q = 1; q <= j; q++){
            if(onec[k - 1] == twoc[q - 1]){
               m[k][q] = m[k-1][q-1];
            }else{
               m[k][q] = min(m[k-1][q], m[k-1][q-1], m[k][q-1]) + 1;
            }
         }
      }
      return m[i][j];
   }

   private int min(int i, int j, int k){
      int min = Integer.MAX_VALUE;
      if(i < min){
         min = i;
      }
      if(j < min){
         min = j;
      }
      if(k < min){
         min = k;
      }
      return min;
   }
}
