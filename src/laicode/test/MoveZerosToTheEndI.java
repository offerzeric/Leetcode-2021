package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/07 16:16
 */
public class MoveZerosToTheEndI {
   public int[] moveZero(int[] array) {
      // Write your solution here
      if(array == null || array.length == 0 || array.length == 1){
         return array;
      }
      int firstZero = -1;
      for(int i = 0; i < array.length;i++){
         if(array[i] == 0){
            firstZero = i;
         }
      }
      if(firstZero == -1){
         return array;
      }
      //i左边不包括i是不是0  [i,j]是待排列区域 j以后不包括j是0
      int i = 0;
      int j = array.length - 1;
      while(i<=j){
         if(array[i] == 0){
            swap(array,i,j);
            j--;
         }else{
            i++;
         }
      }
      return array;
   }
   private void swap(int[] array, int needSwap, int resSwap){
      int temp = array[needSwap];
      array[needSwap] = array[resSwap];
      array[resSwap] = temp;
   }

}
