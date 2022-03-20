package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/20 11:25
 */
public class MaximumPathSumBinaryTreeII {
   public int maxPathSum(TreeNode root) {
      // Write your solution here
      // every recusrsion is a maximun sum of a single path(left or right) of each node
      // recursion: left + right + root.key is the max[0]
      // TC(o(n)) SC(o(n))
      int[] max = new int[]{Integer.MIN_VALUE};
      helper(max,root);
      return max[0];
   }
   private int helper(int[] max, TreeNode root){
      if(root == null){
         return 0;
      }
      int left = helper(max, root.left);
      int right = helper(max, root.right);
      left = left < 0 ? 0 : left;
      right = right < 0 ? 0 : right;
      max[0] = Math.max(left + right + root.key,max[0]);
      return root.key + Math.max(left,right);

   }
}
