package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/13 17:39
 */
public class MaxProductOfCuttingRope {
   public int maxProduct(int length) {
      // 每层切一刀 或者不切 会cover你想要的所有case  多切几刀的case会出现在不同的切一刀的case中返回出最好的结果
      // 除了第一层必须切 其他可切可不切 除了第一层 每层是一样的操作 可以遍历
      // m数组记录每种长度切与不切的所有情况的最大乘积值
      // 不知道n米的 我先求1米的因为我会
      int[] m = new int[length + 1];
      m[0] = -1;
      m[1] = -1;
      for(int i = 2; i <= length; i++){
         int temp = 0;
         for(int j = 1; j < i; j++){
            if(Math.max(j,m[j]) * (i - j) > temp){
               temp = Math.max(j, m[j]) * (i - j);
            }
         }
         m[i] = temp;
      }
      return m[length];
   }
}
