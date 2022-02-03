package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/02 13:33
 */
public class PartitionToTwoParts {
   public void partition(int[] array, int pivotIndex) {
      //first write pivot to the end
      //compare each and pivot smaller to red bigger to blue
      //swap pivot to mid again to return back
      int temp = array[pivotIndex];
      array[pivotIndex] = array[array.length - 1];
      array[array.length - 1] = temp;
      int left = 0;
      int right = array.length - 2;
      //left only one item need to still comapre to 2 part red and blue
      while(left <= right){
         if(array[left] < array[array.length - 1]){
            left++;
         }else{
            swap(array,left,right);
            right--;
         }
      }
      //left and pivot swap cuz array[left]>pivot so swap left will not obey the purpose
      temp = array[left];
      array[left] = array[array.length - 1];
      array[array.length - 1] = temp;

   }
   private void swap(int[] array,int left,int right){
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
   }


}
