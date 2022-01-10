package laicode.test;

/**
 * 二分查找 直到找到正确的数字为止
 *
 * @author ericzhang 2022/01/09 20:11
 */
public class BinarySearch {

    public int binarySearch(int[] array, int target) {
        // Write your solution here
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
