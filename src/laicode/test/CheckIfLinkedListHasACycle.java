package laicode.test;

/**
 * slow 和 fast只要在圆里 一定会相遇
 *
 * @author ericzhang 2022/01/27 14:47
 */
public class CheckIfLinkedListHasACycle {
      public boolean hasCycle(ListNode head) {
         if(head == null || head.next == null){
            return false;
         }
         // write your solution here
         ListNode slow = head;
         ListNode fast = head;
         while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
               return true;
            }
         }
         return false;
      }
}
