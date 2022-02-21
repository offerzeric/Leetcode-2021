package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/20 00:38
 */
public class InsertInBinarySearchTree {
   public TreeNode insert(TreeNode root, int key) {
      // Write your solution here
      if(root == null){
         return new TreeNode(key);
      }
      TreeNode head = root;
      TreeNode pre = null;
      while(head != null){
         pre = head;
         if(head.key == key){
            return root;
         }
         if(head.key < key){
            head = head.right;
         }else{
            head = head.left;
         }
      }
      if(pre != null){
         if(key < pre.key){
            pre.left = new TreeNode(key);
         }else{
            pre.right = new TreeNode(key);
         }
      }
      return root;
   }
}
