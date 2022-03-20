package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/20 11:49
 */
public class MaximumPathSumBinaryTreeI {
   public int maxPathSum(TreeNode root) {
      // Write your solution here
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
      if(root.left == null || root.right == null){
         return root.key+left+right;
      }
      int res = left + right + root.key;
      max[0] = Math.max(max[0],left + right + root.key);
      return root.key + Math.max(left, right);
   }

}
