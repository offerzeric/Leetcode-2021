package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/03 23:12
 */
public class SmallestElementLargerthanTarget {
   public static int smallestElementLargerThanTarget(int[] array, int target) {
      if(array == null || array.length == 0){
         return -1;
      }
      // Write your solution here
      int left = 0;
      int right = array.length - 1;
      int closetIndex = 0;
      //return two elements 时可以直接赋值mid
      while(left < right - 1){
         int mid = left + (right - left) / 2;
         if(array[mid] == target){
            closetIndex = mid;
            break;
         }else if(array[mid] < target){
            left = mid;
         }else{
            right = mid;
         }
      }
      if(array[closetIndex] == target){
         while(closetIndex < array.length){
            if(array[closetIndex] > target){
               return closetIndex;
            }
            closetIndex++;
         }
      }else{
         if(array[left] > target){
            return left;
         }else if(array[right] > target){
            return right;
         }else if(array[right] < target){
            while(right < array.length){
               if(array[right] > target){
                  return right;
               }
               right++;
            }
            return -1;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      int[] ints = {14,27,33,37,40,50,52,53};
      int target = 61;
      int i = smallestElementLargerThanTarget(ints, target);
      System.out.println(i);
   }
}
