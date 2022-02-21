package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/20 00:38
 */
public class SymmetricBinaryTree {
   public boolean isSymmetric(TreeNode root) {
      // Write your solution here
      if(root == null){
         return true;
      }
      return isSymmetric(root.left,root.right);
   }


   private boolean isSymmetric(TreeNode left, TreeNode right) {
      // Write your solution here
      if(left == null && right == null){
         return true;
      }else if(left == null || right == null){
         return false;
      }else if(left.key != right.key){
         return false;
      }
      return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
   }
}
