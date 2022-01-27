package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/27 15:03
 */
public class ReverseLinkedListIterative {
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
      if (head == null) {
         return head;
      }
      //因为head不知道往哪里reverse 所以要pre = null
      ListNode pre = null;
      //因为cur.next = pre;以后cur.next就没有了所以要这个变量存储方便下一次reverse
      ListNode next;
      ListNode cur = head;
      while (cur != null) {
         next = cur.next;
         cur.next = pre;
         pre = cur;
         cur = next;
      }
      //注意linkedList头指针变化了
      return pre;
   }
}
