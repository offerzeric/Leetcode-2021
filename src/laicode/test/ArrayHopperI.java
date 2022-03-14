package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/13 21:50
 */
public class ArrayHopperI {
   public boolean canJump(int[] array) {
      // Write your solution here
      // m[i] represents whether the ith place can go to the end
      // 1 - 2 - 3 - 4
      // 为什么这里数组长度是length 不加1 因为判断的是索引
      boolean[] m = new boolean[array.length];
      m[array.length - 1] = true;
      for(int i = array.length - 2; i >= 0; i--){
         if(array[i] + i >= array.length - 1){
            m[i] = true;
         }else{
            for(int j = 1; j <= array[i];j++){
               //走到这里前面都判断过了
               if(m[i+j]){
                  m[i] = true;
                  break;
               }
            }
         }
      }
      return m[0];
   }
}
