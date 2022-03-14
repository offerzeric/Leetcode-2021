package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/13 16:46
 */
public class LongestAscendingSubArray {
   public int longest(int[] array) {
      // Write your solution here
      if(array.length == 0){
         return 0;
      }
      int[] m = new int[array.length + 1];
      m[0] = 1;
      int globalMax = 1;
      //如果不止看前面一个情况判断不了
      for(int i = 1; i < array.length; i++){
         if(array[i] > array[i - 1]){
            m[i] = m[i-1] + 1;
         }else{
            m[i] = 1;
         }
         if(m[i] > globalMax){
            globalMax = m[i];
         }
      }
      return globalMax;
   }
}
