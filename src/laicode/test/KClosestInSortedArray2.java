package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/03 21:51
 */
public class KClosestInSortedArray2 {
   public static  int[] kClosest(int[] array, int target, int k) {
      if(k == 0){
         return new int[0];
      }
      if(array == null || array.length == 0 || array.length == 1){
         return array;
      }
      // Write your solution here
      int right = array.length - 1;
      int left = 0;
      int[] res = new int[k];
      int resIndex = 0;
      int time = 1;
      int closetIndex = 0;
      while(left < right - 1){
         int mid = left + (right - left) / 2;
         if(array[mid] == target){
            closetIndex = mid;
            left = mid;
            right = mid;
            break;
         }else if(array[mid] < target){
            left = mid;
         }else{
            right = mid;
         }
      }
      closetIndex = (Math.abs(array[left] - target) > Math.abs(array[right] - target))?right:left;
      right = left + 1;
      if(k == 1){
         res[resIndex ++] = array[closetIndex];
      }else{
         for(int i = 0;i < k;i++){
            if(left < 0){
               res[resIndex++] = array[right];
               right++;
            }else if(right >= array.length){
               res[resIndex++] = array[left];
               left--;
            }else if(Math.abs(array[left] - target) > Math.abs(array[right] - target)){
               res[resIndex++] = array[right++];
            }else{
               res[resIndex++] = array[left--];
            }
         }
      }
      return res;
   }

   public static void main(String[] args) {
      int[] ints = {2,2,3};
      int tar = 2;
      int m = 3;
      int[] ews = kClosest(ints,tar,m);
      System.out.println(ews);
   }

}
