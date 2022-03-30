package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/29 22:29
 */
public class LowestCommonAncestorI {
   public TreeNode lowestCommonAncestor(TreeNode root,
                                        TreeNode one, TreeNode two) {
      // Write your solution here.
      // lowestCommonAncestor returns if the one or two is in the  subtree of root
      if(root == null){
         return null;
      }
      if(root == one || root == two){
         return root;
      }
      TreeNode ll = lowestCommonAncestor(root.left, one, two);
      TreeNode lr = lowestCommonAncestor(root.right, one, two);
      if(ll != null && lr != null){
         return root;
      }
      return ll == null ? lr:ll;
   }
}
