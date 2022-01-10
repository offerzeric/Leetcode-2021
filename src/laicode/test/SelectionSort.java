package laicode.test;

/**
 * 一个个遍历 找出此遍历下最小的数 记录他的位置 交换赋值给这次遍历的位置确保每次前面部分都是排序好的
 *
 * @author ericzhang 2022/01/09 19:01
 */
public class SelectionSort {
    public int[] solve(int[] array) {
        // Write your solution here
        for (int i = 0; i < array.length; i++) {
            int min = i;
            int temp = 0;
            for (int j = min; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

}
