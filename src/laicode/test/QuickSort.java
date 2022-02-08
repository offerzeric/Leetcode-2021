package laicode.test;

import java.util.Random;

/**
 * description
 *
 * @author ericzhang 2022/02/02 14:45
 */
public class QuickSort {
   Random rand = new Random();
   public int[] quickSort(int[] array) {
      // Write your solution here
      // base case: the recursion here is part and sort so base case is when no need sort anymore
      // when only left one or zero number can return directly why include zero cuz in this situation there is a probability that no items left
      // recursion: same as base cuz after sort it is all ready
      // sub problem :need whole sort means left and rigth sort
      if(array == null || array.length <= 1){
         return array;
      }
      int left = 0;
      int right = array.length - 1;
      quickSortPart(array,left,right);
      return array;
   }
   private void quickSortPart(int[] array, int left, int right){
      //base case 因为下面的sub recursive调用时跳过咯lastIndex所以有可能直接就left>right了
      if(left >= right){
         return;
      }
      //get the random pivot
      int pivotIndex = left + rand.nextInt(right - left + 1);
      int lastIndex = partition(array,pivotIndex,left,right);
      quickSortPart(array,left,lastIndex - 1);
      quickSortPart(array,lastIndex + 1,right);
   }
   private int partition(int[] array, int pivotIndex, int leftIndex, int rightIndex) {
      //first write pivot to the end
      //compare each and pivot smaller to red bigger to blue
      //swap pivot to mid again to return back
      int temp = array[pivotIndex];
      array[pivotIndex] = array[rightIndex];
      array[rightIndex] = temp;
      int left = leftIndex;
      int right = rightIndex - 1;
      //left only one item need to still comapre to 2 part red and blue
      while(left <= right){
         if(array[left] < array[rightIndex]){
            left++;
         }else{
            swap(array,left,right);
            right--;
         }
      }
      //left and pivot swap cuz array[left]>pivot so swap left will not obey the purpose
      temp = array[left];
      array[left] = array[rightIndex];
      array[rightIndex] = temp;
      return left;
   }
   private void swap(int[] array,int left,int right){
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
   }
}
