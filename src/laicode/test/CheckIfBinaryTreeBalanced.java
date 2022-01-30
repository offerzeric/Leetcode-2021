package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/29 22:01
 */
public class CheckIfBinaryTreeBalanced {
   public boolean isBalanced(TreeNode root) {
      // Write your solution here
      // key point is each node left and right diff is 1 travel everynode to confirm
      // base case
      if(root == null){
         return true;
      }
      //sub: every node needs to balance
      boolean left = isBalanced(root.left);
      boolean right = isBalanced(root.right);

      //recursion  all true --> true
      if(left && right && (Math.abs(getHeight(root.left)-getHeight((root.right)))<=1)){
         return true;
      }else{
         return false;
      }
   }
   private int getHeight(TreeNode root){
      //base case
      if(root == null){
         return 0;
      }
      //sub current heigth + 1
      int left = getHeight(root.left);
      int right = getHeight(root.right);
      //recursion max left , right + 1
      return Math.max(left,right) + 1;

   }

}
