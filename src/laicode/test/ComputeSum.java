package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/05 11:07
 */
public class ComputeSum {
    public int sum(int[] array) {
        if (array.length == 0 || array == null) {
            return -1;
        }
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
        return s;
    }
}
