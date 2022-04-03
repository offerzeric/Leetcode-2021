package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/04/01 23:20
 */
public class MaxPathSumFromLeafToRoot {
   public static int maxPathSumLeafToRoot(TreeNode root) {
      // Write your solution here
      // each level we choose a item whether left or right
      //
      if(root.left == null && root.right == null){
         return root.key;
      }
      if(root.left == null || root.right == null){
         if(root.left != null){
            return root.key+root.left.key;
         }
         if(root.right != null){
            return root.key+root.right.key;
         }
      }
      int[] glo = new int[1];
      int[] res = new int[1];
      maxPathSum(root,glo,res);
      return glo[0];
   }
   private static void maxPathSum(TreeNode root,int[] glo,int[] res){
      if(root == null){
         if(res[0] > glo[0]){
            glo[0] = res[0];
         }
         return;
      }
      res[0] = res[0] + root.key;
      int original = res[0];
      if(root.left != null){
         maxPathSum(root.left,glo,res);
         res[0] = original;
      }
      if(root.right != null){
         maxPathSum(root.right,glo,res);
         res[0] = original;
      }
   }

   public static void main(String[] args) {

   }
}
