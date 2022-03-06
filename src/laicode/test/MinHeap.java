package laicode.test;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * simulate a  minHeap
 *
 * @author ericzhang 2022/03/05 17:52
 */
public class MinHeap {
   private Integer[] array;
   private int size;
   public MinHeap(Integer[] array){
      if(array.length == 0 || array == null) {
         throw  new IllegalArgumentException();
      }
      this.array = array;
      this.size  = array.length;
      heapify();
   }

   public  MinHeap(int num){
      if(num < 0){
         throw new IllegalArgumentException();
      }
      Integer[] arr = new Integer[num];
      this.array = arr;
      this.size = 0;
   }

   public int size(){
      return size;
   }

   public boolean isEmpty(){
      return size==0;
   }

   public boolean isFull(){
      return size == array.length;
   }

   public void percolateUp(int index){
      int start = index;
      int compare = (index - 1)/2;
      while(start > 0 && start <= array.length - 1){
         int original = array[start];
         int ancent = array[compare];
         if(original  <= ancent){
            swap(start,compare);
            start = compare;
            compare = (start - 1)/2;
         }else {
            break;
         }
      }
   }

   public void percolateDown(int index){
      int start = index;
      int compareOne = index*2 + 1;
      int compareTwo = index*2 + 2;
      while(start >= 0 && start <= array.length - 1 && compareTwo >= 0 && compareTwo <= array.length - 1 && compareOne >= 0 && compareOne <= array.length - 1){  //or just make sure the index to compare is <= size / 2 -1 (leaf : index > n/2 - 1)只要比较有叶子节点的就可以
         int original = array[start];
         int ancentOne = array[compareOne];
         int ancentTwo = array[compareTwo];
         int targetIndex = compareNums(compareOne, compareOne);
         if(original  <= array[targetIndex]){
            swap(start,targetIndex);
            start = targetIndex;
            compareOne = start*2 + 1;
            compareTwo = start*2 + 2;
         }else {
            break;
         }
      }
   }

   public int compareNums(int one, int two){
      if(array[one] <= array[two]){
         return one;
      }else{
         return two;
      }
   }

   private void heapify() {
         for(int i = size/2 -1 ; i >= 0; i++) {
             percolateDown(i);
         }
   }

   public int peek(){
      if(size == 0){
         throw new IllegalArgumentException();
      }else{
         return array[0];
      }
   }

   public int poll(){
      if(size == 0){
         throw new NoSuchElementException();
      }
      int res = array[0];
      array[0] = array[size - 1];
      size--;
      percolateDown(0);
      return res;
   }
   public void offer(int ele){
      if(size == array.length){
         array = Arrays.copyOf(array,array.length*2);
      }
      array[size] = ele;
      size++;
      percolateUp(size - 1);
   }

   public  int update(int ele,int index){
         if(index < 0 || index > size - 1){
            throw new ArrayIndexOutOfBoundsException();
         }
         int original = array[index];
         array[index] = ele;
         if(original < ele){
            percolateDown(index);
         }else {
            percolateUp(index);
         }
         return original;
   }

   private void swap(int l, int r){
      int temp = array[l];
      array[l] = array[r];
      array[r] = temp;
   }

}
