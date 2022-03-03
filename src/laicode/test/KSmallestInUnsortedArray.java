package laicode.test;

import java.util.Arrays;

/**
 * description
 *
 * @author ericzhang 2022/02/27 16:39
 */
public class KSmallestInUnsortedArray {
   public int[] kSmallest(int[] array, int k) {

   //quickSort 先排列后取前k个
   //maxHeap先init 后n-k个不断比较小的就插入  保证最后整完的heap肯定是最小的k个 直接poll
   // if(array.length == 0 || k == 0){
   //   return new int[0];
   // }
   // //PriorityQueue heap&graph ArrayDeque stack&queue
   // PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
   //   @Override
   //   public int compare(Integer v1, Integer v2){
   //     if(v1.equals(v2)){
   //       return 0;
   //     }
   //     return v1 > v2?-1:1;
   //   }
   // });
   // for(int i = 0;i < array.length;i++){
   //   if(i < k){
   //     queue.offer(array[i]);
   //   }else{
   //     if(array[i] < queue.peek()){
   //       queue.poll();
   //       queue.offer(array[i]);
   //     }
   //   }
   // }
   // int[] res = new int[k];
   // for(int i = k-1;i >= 0;i--){
   //   res[i] = queue.poll();
   // }
   // return res;
    if(array.length == 0 || k == 0 ){
      return new int[0];
   }
   quickSort(array,0,array.length - 1,k - 1);
   int[] res = Arrays.copyOf(array,k);
    Arrays.sort(res);
    return res;
}
   public void quickSort(int[] array,int left,int right,int k){
      int lastIndex = partition(array,left,right);
      if(lastIndex == k){
         return;
      }else if(lastIndex < k){
         quickSort(array,lastIndex+1,right,k);
      }else{
         quickSort(array,left,lastIndex-1,k);
      }
   }

   private int partition(int[] array,int left,int right){
      int pivot = array[right];
      int end = right - 1;
      int start = left;
      while(start <= end){
         if(array[start] <= pivot){
            start++;
         }else{
            swap(array,start,end);
            end--;
         }
      }
      swap(array,start,right);
      return start;
   }
   private void swap(int[] array,int start,int end){
      int temp = array[start];
      array[start] = array[end];
      array[end] = temp;
   }
}
