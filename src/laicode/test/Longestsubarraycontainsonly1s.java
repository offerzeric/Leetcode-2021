package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/27 17:08
 */
public class Longestsubarraycontainsonly1s {
   public int longestConsecutiveOnes(int[] nums, int k) {
      // 1,1,0,0,1,1,1,0,0,0
      // f
      // s
      // Write your solution here
      int fast = 0;
      int slow = 0;
      int longest = 0;
      int countFlip = 0;
      while(fast < nums.length){
         if(nums[fast] == 1){
            longest = Math.max(longest,++fast - slow);
         }else if(countFlip < k){
            longest = Math.max(longest,++fast - slow);
            countFlip++;
         }else if(nums[slow++] == 0){
            countFlip--;
         }
      }
      return longest;
   }
}
