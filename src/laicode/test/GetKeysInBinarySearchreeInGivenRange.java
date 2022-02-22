package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/02/21 01:34
 */
public class GetKeysInBinarySearchreeInGivenRange {
   ArrayList<Integer> list = new ArrayList();
   public List<Integer> getRange(TreeNode root, int min, int max) {
      // Write your solution here
      if(root == null){
         return list;
      }
      inOrder(root,min,max);
      return list;
   }
   private void inOrder(TreeNode root,int min,int max){
      if(root == null){
         return;
      }
      inOrder(root.left,min,max);
      if(root.key <= max && root.key >= min){
         list.add(root.key);
      }
      inOrder(root.right,min,max);
   }

}
