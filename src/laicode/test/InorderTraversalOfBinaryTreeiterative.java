package laicode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/02/21 17:06
 */
public class InorderTraversalOfBinaryTreeiterative {
   public List<Integer> inOrder(TreeNode root) {
      // Write your solution here
      //left has value then go left and stack the item
      // left is null pop stack add list and go to the pop's right
      ArrayList<Integer> list = new ArrayList();
      if(root == null){
         return list;
      }
      Deque<TreeNode> stack = new ArrayDeque();
      TreeNode helper = root;
      while(!stack.isEmpty() || helper != null){
         if(helper != null){
            stack.offerFirst(helper);
            helper = helper.left;
         }else{
            TreeNode res = stack.pollFirst();
            list.add(res.key);
            helper = res.right;
         }
      }
      return list;
   }
}
