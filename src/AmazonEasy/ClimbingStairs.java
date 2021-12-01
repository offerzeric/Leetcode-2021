package AmazonEasy;

/**
 * 爬楼梯 一次只能爬1-2层
 * 爬三层的总方法就是爬一层的总数+爬两层的总数
 * 直接递归会time exceed
 *
 * @author ericzhang 2021/11/30 4:00 下午
 */
public class ClimbingStairs {

    public class Solution {
        public int climbStairs(int n) {
            if(n==1){
                return 1;
            }
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3;i<dp.length;i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
    }

}
