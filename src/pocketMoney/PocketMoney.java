package pocketMoney;

import org.junit.Test;

/**
 * DP
 * 1,2,5三张面额凑出11元  张数最小解
 * 只能解决满足  最优子结构    （每个子问题互相独立）求张数最小 去掉一张求最小这个子任务和最后加一张这个子任务互相独立不影响
 * 状态转移方程   找到递归方法   方程返回值是在该amount下最优解为几张  amount=0不需要  amount=-1为负数也不需要
 * 重叠子问题  后续备忘录存储已经求过的值进行优化
 * 我根本不care dp是怎么递归出来的  我定义的函数的作用就是把要求的最后结果的算法定义出来
 * @author ericzhang 2021/08/15 12:37 上午
 */
public class PocketMoney {

    //求当前amount下和coins下的最小数量
    public int dp(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if(subProblem == -1) continue;
            res = Math.min(res,subProblem+1);
        }
        return res == Integer.MAX_VALUE?-1:res;
    }

    @Test
    public void test() {
        int[] coins = {1,2,5};
        int dp = dp(coins, 11);
        System.out.println(dp);
    }
}
