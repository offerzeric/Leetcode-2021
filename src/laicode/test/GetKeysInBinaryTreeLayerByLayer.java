package laicode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * description
 *
 * @author ericzhang 2022/02/27 17:17
 */
public class GetKeysInBinaryTreeLayerByLayer {
   public List<List<Integer>> layerByLayer(TreeNode root) {
      // Write your solution here
      List<List<Integer>> list = new ArrayList();
      if(root == null){
         return new ArrayList();
      }
      if(root.left == null &&  root.right == null){
         ArrayList<Integer> cur = new ArrayList();
         cur.add(root.key);
         list.add(cur);
         return list;
      }
      Queue<TreeNode> res = new ArrayDeque();
      res.offer(root);
      while(!res.isEmpty()){
         ArrayList<Integer> cur = new ArrayList();
         int size = res.size();
         for(int i = 0;i<size;i++){
            TreeNode temp = res.poll();
            cur.add(temp.key);
            if(temp.left != null){
               res.offer(temp.left);
            }
            if(temp.right != null){
               res.offer(temp.right);
            }
         }
         list.add(cur);
      }
      return list;
   }

}
