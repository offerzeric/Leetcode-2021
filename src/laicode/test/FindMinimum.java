package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/05 09:52
 */
public class FindMinimum {
    public int min(int[] array) {
        // Write your solution here
        int res = 0;
        for(int i=0;i<array.length;i++){
            if(res > array[i]){
                res = array[i];
            }
        }
        return res;
    }

}
