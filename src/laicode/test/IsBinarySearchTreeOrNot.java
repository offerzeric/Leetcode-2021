package laicode.test;

import java.util.ArrayList;

/**
 * description
 *
 * @author ericzhang 2022/02/20 01:06
 */
public class IsBinarySearchTreeOrNot {
   public static boolean isBST(TreeNode root) {
      // Write your solution here
      //base case null is right
      // sub pro: root is means all sub is
      // recursion rule: every sub is all is
//      if(root == null){
//         return true;
//      }
//      if(root.left != null && root.left.key >= root.key){
//         return false;
//      }
//      if(root.right != null && root.right.key <= root.key){
//         return false;
//      }
//      return isBST(root.left) && isBST(root.right);
      return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
   }
   private static boolean isBST(TreeNode root, int min, int max){
      if(root == null){
         return  true;
      }
      if(root.key<=min || root.key>=max){
         return  false;
      }
      return isBST(root.left,min,root.key)
            &&isBST(root.right,root.key,max);
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
