package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/27 15:24
 */
public class ReverseLinkedListRecursive {
   /**
    * class ListNode {
    * public int value;
    * public ListNode next;
    * public ListNode(int value) {
    * this.value = value;
    * next = null;
    * }
    * }
    */
   public ListNode reverse(ListNode head) {
      // Write your solution here
      //corner case && 递归base case 即找到newHead以后进行recursion
      if (head == null || head.next == null) {
         return head;
      }
      ListNode newHead = reverse(head.next);
      head.next.next = head;
      //新的尾结点没有点去处理他的next会形成循环
      head.next = null;
      return newHead;

   }


}
