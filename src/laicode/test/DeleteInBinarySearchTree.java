package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/21 15:41
 */
public class DeleteInBinarySearchTree {
   public TreeNode deleteTree(TreeNode root, int key) {
      // Write your solution here
      // find the target  && process all ways to 挂树
      // case 1 delete leaf 直接delete 悬挂
      // case 2 delete node has left or right  直接delete 进行挂树
      // case 3 find the smallest node in the right sub
      // if this node doesnt have left tree : make the node's right tree to the delete node also delete's left need to put up to this node
      // else this node has left tree: get the smallest node in left tree. make the right tree of smallest node to the to the parent node of the smallest node
      // return the smallest to the root to hang up and it takes the left and right node of the delete node

      if(root == null){
         return null;
      }
      if(root.key < key){
         root.right = deleteTree(root.right,key);
         return root;
      }
      if(root.key > key){
         root.left = deleteTree(root.left,key);
         return root;
      }
      if(root.left == null){
         return root.right;
      }else if(root.right == null){
         return root.left;
      }else{
         if(root.right.left == null){
            root.right.left = root.left;
            return root.right;
         }else{
            TreeNode smallest = null;
            smallest = findSmallestInLeftAndProcessIt(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
         }
      }
   }
   private TreeNode findSmallestInLeftAndProcessIt(TreeNode root){
      TreeNode pre = root;
      root = root.left;
      while(root.left != null){
         pre = root;
         root = root.left;
      }
      pre.left = root.right;
      return root;
   }
}
