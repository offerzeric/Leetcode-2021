package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/29 21:46
 */
public class CountNode {
   public int countNodes(TreeNode root) {
      // Write your solution here
      //base case: null -> 0;
      if(root == null){
         return 0;
      }
      //sub: left + right all heads
      int left = countNodes(root.left);
      int right = countNodes(root.right);
      //recursion rule left + right sub heads + 1
      return left + right + 1;
   }

}
