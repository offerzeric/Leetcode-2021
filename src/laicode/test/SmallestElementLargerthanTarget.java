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
         if(array[mid] <= target){
            left = mid + 1;
         }else{
            right = mid;
         }
      }
      //left and right all can be < > = target just need to identify the problem needs
      //如果target在数组最后或者数组没有target 最后返回两个值时都是在数组最后两位
      //如果target在数组中间 且没有target时 直接根据题目需求判断也可以cover
      //总之Binary search拿到的两个值就是离target最近的两个值 只要判断这两个是否满足题目need即可
      if(array[left] > target){
         return left;
      }
      if(array[right] > target){
         return right;
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
