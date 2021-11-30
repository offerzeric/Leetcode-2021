package DutchFlag;

/**
 * 给定一个数组  和 num
 *  用O(N)的复杂度去 把小于Num的数字放数组左边 大于Num的数字放数组右边
 *  给定两个下标 i 和 p  p代表小于等于范围内的下标   i是数组往后移动的下标
 *  如果arr[i]小于等于num  arr[i]置换到p的下一个位置  p++ i++ 如果arr[i]大于num 则i++即可
 * @author ericzhang 2021/08/25 10:18 上午
 */
public class DutchFlag {

    int[] arr = {3,4,7,6,4,5,3,4,7};
    int num = 5;
    int p = 0;
    public void sort(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= num){
                
            }
        }

    }


}
