package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/16 15:16
 */
public class StoreNumberOfNodesInLeftSubtree {
   public void numNodesLeft(TreeNodeLeft root) {
      // Write your solution here
      // when node is null res is 0 when node has no left child 0
      // sub: node's left numNodesLeft + node's left’s right + 1  做不了 因为 不能cover所有点的计算
      // sub: get the total number of subtree include the number itself 返回的结果不是直接能用的结果
      // recursion rule:  for each node sub-left tree result + sub left tree right + 1
      // TC:o(n) sc o(1)
      TreeNodeLeft head = root;
      recursive(head);
   }

   private int recursive(TreeNodeLeft head){
      if(head == null){
         return 0;
      }
      int left = recursive(head.left);
      int right = recursive(head.right);
      head.numNodesLeft = left;
      return left + right + 1;
   }
}
