package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/03 21:51
 */
public class KClosestInSortedArray {
   public static int[] kClosest(int[] array, int target, int k) {
      if(array == null || array.length == 0 || array.length == 1){
         return array;
      }
      if(k == 0){
         return new int[0];
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
         }else if(array[mid] < target){
            left = mid;
         }else{
            right = mid;
         }
      }
      closetIndex = (Math.abs(array[left] - target) > Math.abs(array[right] - target))?right:left;
      if(k == 1){
         res[resIndex ++] = array[closetIndex];
      }else{
         res[resIndex++] = array[closetIndex];
         int minus = closetIndex ;
         int plus = closetIndex;
         while(time < k){
            if(plus+1 < array.length){
                if(minus-1 >= 0) {
                   res[resIndex++] = (Math.abs(array[plus+1] - target) < Math.abs(array[minus-1] - target)) ? array[plus+1] : array[minus-1];
                   if(array[plus+1] == res[resIndex-1]){
                      plus++;
                   }
                   if(array[minus-1] == res[resIndex-1]){
                      minus--;
                   }
                }else {
                   if(resIndex < k) {
                      res[resIndex++] = array[plus + 1];
                      plus++;
                   }
                }
                time++;
            }
            if(minus-1 >= 0){
               if(plus+1 <array.length) {
                  res[resIndex++] = (Math.abs(array[plus+1] - target) < Math.abs(array[minus-1] - target)) ? array[plus+1] : array[minus-1];
                  if(array[plus+1] == res[resIndex-1]){
                     plus++;
                  }
                  if(array[minus-1] == res[resIndex-1]){
                     minus--;
                  }
               }else {
                  if(resIndex < k) {
                     res[resIndex++] = array[minus - 1];
                     minus--;
                  }
               }
               time++;
            }
         }
      }
      return res;
   }

   public static void main(String[] args) {
      int[] ints = {1,3,3,6,9,9,12,15};
      int tar = 10;
      int m = 5;
      int[] ews = kClosest(ints,tar,m);
      System.out.println(ews);

   }

}
