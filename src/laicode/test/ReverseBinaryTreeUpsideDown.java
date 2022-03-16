package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/16 15:17
 */
public class ReverseBinaryTreeUpsideDown {
   public TreeNode reverse(TreeNode root) {
      // Write your solution here
      // left leaf node is newHead  原来right要变left 原来left边right
      // base case: root == null || root.left == null -> root
      // sub: every left node needs change
      // recursive each change return the whole new Head
      // TC o(n) SC(o(n))
      if(root == null || root.left == null){
         return root;
      }
      TreeNode newHead = reverse(root.left);
      root.left.left = root;
      root.left.right = root.right;
      root.left = null;
      root.right = null;
      return newHead;
   }
}
