package allSort;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 全排列 1，2，3
 *
 * @author ericzhang 2021/08/17 11:10 上午
 */
public class AllSort {
    int[] nums = {1,2,3};
    LinkedList<Integer> track = new LinkedList<>();
    LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    public void  allSortPlay(int[] nums){
        int i = 0;
        //如果已经完全相等了  那就是遍历结束了
        if(track.size() == nums.length){
            //linkedlist加入add是引用加入  如果后面track removelast以后会影响res的结果 所以这里只能新建
            res.add(new LinkedList<>(track));
            return;
        }
        //从第二个数开始的增加操作
        for(i = 0; i < nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            //每次单独的找一个值都是先加   再移除
            track.add(nums[i]);
            allSortPlay(nums);
            //track中每次加上一个 下面的选择都需要全部备选项的遍历  如果return了证明排列完了  则可以把这个位置的这个元素删除 给这个位置的下一个元素排列
            track.removeLast();
        }
    }
    @Test
    public void test() {
        allSortPlay(nums);
        System.out.println(res);
    }
}
