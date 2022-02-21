package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/18 22:53
 */
public class ArrayToTree {

   public static TreeNode trans(int[] array){
      TreeNode treeNode = new TreeNode(array[0]);
      TreeNode res = treeNode;
      TreeNode pre = null;
      for (int i = 1; i < array.length; i++) {
         TreeNode temp = new TreeNode(array[i]);
         while (res != null){
            pre = res;
            if(temp.key < res.key){
               res = res.left;
            }else{
               res = res.right;
            }
         }
         if(temp.key < pre.key){
            pre.left = temp;
         }else{
            pre.right = temp;
         }
         res = treeNode;
      }
      return treeNode;
   }

   public static void main(String[] args) {
      int[] arr = {4,6,3,2,5};
      TreeNode trans = trans(arr);
      while (trans.right!=null){
         System.out.print(trans.key + " ");
         trans = trans.right;
      }
   }
}
