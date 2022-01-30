package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/01/29 21:22
 */
public class PreOrderTraversalOfBinaryTree {
   /**
    * public class TreeNode {
    *   public int key;
    *   public TreeNode left;
    *   public TreeNode right;
    *   public TreeNode(int key) {
    *     this.key = key;
    *   }
    * }
    */
      public List<Integer> preOrder(TreeNode root) {
         // Write your solution here
         ArrayList<Integer> list = new ArrayList<>();
         //base case
         if(root == null){
            return list;
         }
         //sub problem
         list.add(root.key);
         list.addAll(preOrder(root.left));
         list.addAll(preOrder(root.right));
         return list;
      }

}
