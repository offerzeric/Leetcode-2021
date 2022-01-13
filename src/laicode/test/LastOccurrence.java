package laicode.test;

/**
 * 必定是找两个范围
 *
 * @author ericzhang 2022/01/12 19:20
 */
public class LastOccurrence {
      public int lastOccur(int[] array, int target) {
         // Write your solution here
         if(array==null || array.length==0){
            return -1;
         }
         int start = 0;
         int end = array.length - 1;
         while(start < end - 1){
            int mid = start + (end-start)/2;
            if(array[mid] > target){
               end = mid - 1;
            }else if(array[mid] < target){
               start = mid + 1;
            }else{
               //为了找最后一次出现 所以移动start
               start = mid;
            }
         }
         if(array[end] == target){
            return end;
         }
         if(array[start] == target){
            return start;
         }
         return -1;
   }

}
