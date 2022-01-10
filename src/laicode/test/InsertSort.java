package laicode.test;

/**
 * 插入排序 拿到一个值记录这个值的值和位置 与他前面的每一个比 比他大就把大的往后面移动
 * 数组值传递直接是引用传递 传递的是数组的地址
 *
 * @author ericzhang 2022/01/09 18:39
 */
public class InsertSort {
    public int[] sort(int[] array) {
        // Write your solution here
        int temp = 0;
        if (array == null || array.length == 0) {
            return array;
        } else {
            insertSort(array);
            return array;
        }
    }


    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }


}
