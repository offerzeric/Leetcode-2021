package laicode.test;

import java.util.Random;

/**
 * description
 *
 * @author ericzhang 2022/02/02 14:45
 */
public class QuickSortTest {
   Random rand = new Random();
   public int[] quickSort(int[] array) {
      if(array == null || array.length == 0 || array.length == 1){
         return array;
      }
      int left = 0;
      int right = array.length - 1;
      quickSortNew(left,right,array);
      return array;
   }
   private void quickSortNew(int left,int right,int[] array){
      //base case
      if(left >= right){
         return;
      }
      //sub problem && recursive rule: left and right all sorted
      int pivot = left + rand.nextInt(right-left+1);
      int last = division(array,pivot,left,right);
      quickSortNew(left,last-1,array);
      quickSortNew(last+1,right,array);
   }
   private int division(int[] array,int pivot,int left,int right){
      swap(array,pivot,right);
      int i = left;
      int j = right - 1;
      while(i<=j){
         if(array[i] <= array[right]){
            i++;
         }else{
            swap(array,i,j);
            j--;
         }
      }
      swap(array,i,right);
      return i;
   }
   private void swap(int[] array,int left,int right){
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
   }

}
