package AmazonEasy;

/**
 * description
 *
 * @author ericzhang 2021/12/01 7:42 下午
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        class Solution {
            public void merge(int[] nums1, int m, int[] nums2, int n) {
                int tail1 = m-1;
                int tail2 = n-1;
                int finished = m+n-1;
                while(tail1>=0 && tail2>=0){
                    nums1[finished--] = (nums1[tail1]>nums2[tail2])?nums1[tail1--]:nums2[tail2--];

                }
                while (tail2 >= 0) { //only need to combine with remaining nums2
                    nums1[finished--] = nums2[tail2--];
                }

            }

        }
    }

}
