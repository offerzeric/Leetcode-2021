package laicode.test;

import java.util.ArrayList;

/**
 * description
 *
 * @author ericzhang 2022/02/20 01:06
 */
public class IsBinarySearchTreeOrNot {
   int pre = Integer.MIN_VALUE;
   public static  boolean isBST(TreeNode root) {
      int pre = Integer.MIN_VALUE;
      // Write your solution here
      //base case null is right
      // sub pro: root is means all sub is
      // recursion rule: every sub is all is
      // #1 in order travel then store check will there be a item is smaller than latter
      // #2 pre order recursion check everytime is there sth wrong
      // #1
      if(root == null){
         return true;
      }
      boolean left = isBST(root.left);
      if(pre >= root.key){
         return false;
      }
      pre = root.key;
      boolean right = isBST(root.right);
      return left&&right;
   }

   public static void main(String[] args) {
//      int[] a = {5,4,8,2,6};
//      TreeNode trans = ArrayToTree.trans(a);
      TreeNode head = new TreeNode(5);
      TreeNode head1 = new TreeNode(4);
      TreeNode head2 = new TreeNode(8);
      TreeNode head3 = new TreeNode(2);
      TreeNode head4 = new TreeNode(6);
      head.left =head1;
      head.right= head2;
      head1.left = head3;
      head1.right = head4;
      boolean bst = isBST(head);

   }
}
