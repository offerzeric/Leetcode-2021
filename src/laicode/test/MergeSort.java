package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/30 21:34
 */
public class MergeSort {
   public int[] mergeSort(int[] array) {
      // Write your solution here
      if(array.length == 0 || array == null){
         return array;
      }
      // sub: want the whole sort means left and right sort then sort left and right
      // base case: only one item return array cuz binary split will always get an answer this the end of split part to get the actually number to merge sort
      // recursion rule: every left and right to merge sort
      int left = 0;
      int right = array.length - 1;
      return mergeSortPart(array,left,right);
   }
   private int[] mergeSortPart(int[] array,int left,int right){
      if(left == right){
         return new int[] {array[left]};
      }
      int mid = left + (right-left)/2;
      //find the leaf num then this the end of split to two this means find the first one to do merge
      int[] leftRes = mergeSortPart(array,left,mid);
      int[] rightRes = mergeSortPart(array,mid+1,right);
      return merge(leftRes,rightRes);
   }
   private int[] merge(int[] left, int[] right){
      int[] res = new int[left.length + right.length];
      int s1 = 0;
      int s2 = 0;
      int index = 0;
      while(s1 < left.length && s2 < right.length){
         if(left[s1] < right[s2]){
            res[index] = left[s1];
            s1++;
         }else{
            res[index] = right[s2];
            s2++;
         }
         index++;
      }
      while(s1 <= left.length - 1){
         res[index++] = left[s1++];
      }
      while(s2 <= right.length - 1){
         res[index++] = right[s2++];
      }
      return res;
   }

}
