package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/20 11:22
 */
public class MaximumPathSumBinaryTreeIII {
   public int maxPathSum(TreeNode root) {
      // Write your solution here
      // base case: if root == null the sum path is zero
      // we want the maximum so we need every max of each node
      // recursion: each recursion represents the maximun maximun sum of signal path
      int[] max = new int[]{Integer.MIN_VALUE};
      helper(max,root);
      return max[0];
   }
   private int helper(int[] max, TreeNode root){
      if(root == null){
         return 0;
      }
      int left = helper(max,root.left);
      int right = helper(max,root.right);
      left = left > 0?left:0;
      right = right > 0?right:0;
      int res = Math.max(left,right) + root.key;
      max[0] = Math.max(max[0],res);
      return res;

   }
}
