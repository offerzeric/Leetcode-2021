package stepNum4Pair;

import org.junit.Test;


/**
 *  可以用增删改进行修改s1字符串使她和s2字符串一样  计算最小的需要的步数
 *  base: 当任意一个走完 只需要删除或者增加剩余一个字符串的个数即可确认最后增删改操作步数return
 *  函数dp即直接得到字符串转换需要的步数
 * @author ericzhang 2021/08/15 10:48 上午
 */
public class StepNum4pair {

    public int dp(int[] s1, int[] s2, int index1, int index2, int[][] mem){
        if(index1 == -1) return index2+1;
        if(index2 == -1) return index1+1;
        //取增删改一次以后各自接下来最小的改动步数
        if(mem[index1][index2] != 0){
            return mem[index1][index2];
        }
        if(s1[index1] == s2[index2]) {
            mem[index1][index2] = dp(s1, s2, index1-1, index2-1, mem);
        }
        else {
                //如果是增加
                int increase = dp(s1, s2, index1, index2 - 1,mem) + 1;
                //如果是删除
                int delete = dp(s1, s2, index1 - 1, index2,mem) + 1;
                //如果是更改
                int update = dp(s1, s2, index1 - 1, index2 - 1,mem) + 1;
                mem[index1][index2] = Math.min(increase,Math.min(delete,update));
        }
        return mem[index1][index2];
    }

    @Test
    public void test() {
        int[] arr1= {1,3,3};
        int[] arr2= {3,2,3};
        int[][] mem = new int[5][5];
        int dp = dp(arr1,arr2,2,2,mem);
        System.out.println(dp);
    }
}
