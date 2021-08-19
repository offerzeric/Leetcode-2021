package algo;

/**
 * 动态规划  求最值 DFS
 * 只能解决满足  最优子结构  状态转移方程  重叠子问题
 *
 * @author ericzhang 2021/08/14 8:12 上午
 */

//初始化base case  dp[0][0]... = base
//进行状态转移
//    for 状态1 in 状态1 所有取值
//        for 状态2 in 状态2 所有取值
//            for....
// dp[状态1][状态2][状态3] = 求最值(选择1  选择2...)
//递归函数的时间复杂度 = 每个递归的复杂度乘递归次数

//o(1) * o(n)  = o(n)  空间换时间复杂度  每次递归复杂度o(1) 一共递归n次 所以是o(n)

public class DynamicProgramming {


}


