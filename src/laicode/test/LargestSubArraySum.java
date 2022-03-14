package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/13 23:37
 */
public class LargestSubArraySum {
   public int largestSum(int[] array) {
      // Write your solution here
      // dp: m[i] determines the greastest sum of subarray in index i
      // base case: m[0] = array[0]
      // induction rule:
      //1. itself is the greatest sum
      //2. plus previous is greater
      // thus if previous is smaller than 0 we just need the itself
      // else we need the sum
      if(array.length == 1){
         return array[0];
      }
      int[] m = new int[array.length];
      int globalMax = Integer.MIN_VALUE;
      m[0] = array[0];
      for(int i = 1; i < array.length; i++){
         if(m[i - 1] < 0){
            m[i] = array[i];
         }else{
            m[i] = m[i - 1] + array[i];
         }
         if(globalMax == Integer.MIN_VALUE){
            globalMax = m[i];
         }
         if(m[i] > globalMax){
            globalMax = m[i];
         }
      }
      return globalMax;

      // int cur = array[0];
      // int globalMax = Integer.MIN_VALUE;
      // for(int i = 1; i < array.length; i++){
      //   cur = Math.max(cur+array[i],array[i]);
      //   globalMax = Math.max(globalMax,cur);
      // }
      // return globalMax;
   }
}
