package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/20 11:49
 */
public class MaximumPathSumBinaryTreeI {
   public int maxPathSum(TreeNode root) {
      // Write your solution here
      // none leaf node can return the left+ right + root as the result
      // leaf node can  or miss one item node return the valid part(itself or the valid branch sum) cannot update max
      int[] max = new int[]{Integer.MIN_VALUE};
      helper(max,root);
      return max[0];
   }
   private int helper(int[] max, TreeNode root) {
      if (root == null) {
         return 0;
      }
      int left = helper(max, root.left);
      int right = helper(max, root.right);
      if(root.left != null && root.right != null){
         max[0] = left + right + root.key;
         return Math.max(left,right) + root.key;
      }else{
         if(root.left == null){
            return right + root.key;
         }else if(root.right == null){
            return left + root.key;
         }else {
            return root.key;
         }
      }
   }

}
