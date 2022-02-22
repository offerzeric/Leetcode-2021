package laicode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/02/21 16:23
 */
public class PreorderTraversalOfBinaryTreeiterative {
   private ArrayList<Integer> list = new ArrayList();
   public List<Integer> preOrder(TreeNode root) {
      // Write your solution here
      // pop 栈顶并打印 右进去 左进去
      if(root == null){
         return list;
      }
      Deque<TreeNode> stack = new ArrayDeque();
      stack.offerFirst(root);
      while(!stack.isEmpty()){
         TreeNode res = stack.pollFirst();
         list.add(res.key);
         if(res.right != null){
            stack.offerFirst(res.right);
         }
         if(res.left != null){
            stack.offerFirst(res.left);
         }
      }
      return list;
   }
}
