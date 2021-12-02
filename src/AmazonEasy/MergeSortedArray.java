package AmazonEasy;

/**
 * 第一个循环就是把第一个array和第二个array中的数字进行对比
 * 因为本身是递增的并且都是从最后开始取（最大）所以可以保证每次取出的都是最大的 先插入到num1的最后
 * 第一个loop结束证明最大的数已经取完了
 * 剩余如果num1已经取完 num2还有数证明num2剩下的数都是最小的直接拼到前面就好了
 * 如果num2已经取完 num1还有数则不用动  因为剩下的数肯定是最小的 Num1本身就在Num1中
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
