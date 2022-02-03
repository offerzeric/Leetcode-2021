package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/02 18:15
 */
public class RainbowSort {
   public int[] rainbowSort(int[] array) {
      // Write your solution here
      if(array == null || array.length == 0){
         return array;
      }
      int i = 0;
      int j = 0;
      int k = array.length-1;
      while(j<=k){
         if(array[j] == -1){
            swap(array,i,j);
            i++;
            j++;
         }else if(array[j] == 0){
            j++;
         }else{
            swap(array,j,k);
            k--;
         }
      }
      return array;
   }

   private void swap(int[] array,int left,int right){
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
   }
}
