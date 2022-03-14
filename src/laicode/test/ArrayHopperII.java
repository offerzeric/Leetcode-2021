package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/03/13 23:19
 */
public class ArrayHopperII {
   public int minJump(int[] array) {
      // Write your solution here
      // dp :m[i] represents the minimum number of jumps you need to reach the end of array in ith place
      // base case:     m[array.length - 1] = 0;
      // induction rule :
      // 1. the ith place can go to the end directly
      // 2. the ith place need to go to the mid point to relay to end
      // get the min method
      int[] m = new int[array.length];
      Arrays.fill(m,-1);
      m[array.length - 1] = 0;
      // int iter = -1
      for(int i = array.length - 2; i >= 0; i--){
         int relay = -1;
         for(int j = 1; j <= array[i]; j++){
            //自己走过去没必要因为跳着肯定比自己走快
            // if(i + j >= array.length){
            //   if(j < iter){
            //     iter = j;
            //   }
            // }
            if((i+j) <= array.length - 1 && m[i+j] >= 0 && relay == -1){
               relay = m[i+j]+1;
            }else if((i+j) <= array.length - 1 && m[i+j] >= 0  && m[i+j]+1 < relay){
               relay = m[i+j]+1;
            }
         }
         m[i] = relay;
      }
      return m[0];
   }
}
