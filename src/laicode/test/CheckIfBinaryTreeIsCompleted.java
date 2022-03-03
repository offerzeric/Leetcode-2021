package laicode.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * description
 *
 * @author ericzhang 2022/02/28 12:40
 */
public class CheckIfBinaryTreeIsCompleted {
   public static boolean isCompleted(TreeNode root) {
      // Write your solution here
      if(root == null){
         return true;
      }
      Queue<TreeNode> queue = new ArrayDeque();
      queue.offer(root);
      boolean bubble = false;
      while(!queue.isEmpty()){
         int size = queue.size();
         TreeNode temp = queue.poll();
         if(temp.left == null){
            bubble = true;
         }else if(bubble){
            return false;
         }else{
            queue.offer(temp.left);
         }

         if(temp.right == null){
            bubble = true;
         }else if(bubble){
            return false;
         }else{
            queue.offer(temp.right);
         }
      }
      return true;
   }

   public static void main(String[] args) {
      TreeNode t1 = new TreeNode(1);
      TreeNode t2 = new TreeNode(2);
      TreeNode t3 = new TreeNode(3);
      TreeNode t4 = new TreeNode(4);
      t1.left = t2;
      t1.right = t3;
      t2.left = t4;
      isCompleted(t1);

   }
}
