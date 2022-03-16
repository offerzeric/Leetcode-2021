package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/15 15:55
 */
public class ReverseLinkedListInPairs {
   public ListNode reverseInPairs(ListNode head) {
      // Write your solution here
      if(head == null || head.next == null ){
         return head;
      }
      ListNode dummy = head;
      ListNode newHead = change(dummy);
      dummy.next = reverseInPairs(dummy.next);
      return newHead;
   }

   private ListNode change(ListNode node){
      ListNode temp = node.next;
      node.next = node.next.next;
      temp.next = node;
      return temp;
   }
}
