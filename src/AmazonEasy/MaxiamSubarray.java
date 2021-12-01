package AmazonEasy;

/**
 *找出所有可能的相加总和中最大的
 * 本质上就是一行加过去  如果加的数大于本数或者加了之后大于本数就算上
 *
 * @author ericzhang 2021/11/30 2:04 下午
 */
public class MaxiamSubarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            int maxValue = Integer.MIN_VALUE;
            if(nums.length == 1){
                return nums[0];
            }
            for(int i=0;i<nums.length;i++){
                int currentValue = 0;
                for(int j=i;j<nums.length;j++){
                    currentValue+=nums[j];
                    maxValue = Math.max(currentValue,maxValue);
                }
            }
            return maxValue;
        }
    }

}
