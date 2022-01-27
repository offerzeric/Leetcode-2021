package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/27 14:45
 */
public class FindtheMiddleNodeEvenNum {

      public ListNode findMiddleNode(ListNode head) {
         if(head == null){
            return null;
         }
         // Write your solution here
         ListNode slow = head;
         ListNode fast = head;
         while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
         }
         return slow;
      }

}
