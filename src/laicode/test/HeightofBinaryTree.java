package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/29 21:42
 */
public class HeightofBinaryTree {
   public int findHeight(TreeNode root) {
      // Write your solution here
      //base case
      if(root == null){
         return 0;
      }
      //sub: current height + 1
      int left = findHeight(root.left);
      int right = findHeight(root.right);
      //recursion rule: -> result needs max current height + 1
      return Math.max(left,right) + 1;
   }

}
