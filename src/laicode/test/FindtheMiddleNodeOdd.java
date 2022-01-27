package laicode.test;

/**
 *  找中点 快慢指针法则  likedlist多考虑快慢或者起始指针
 *
 * @author ericzhang 2022/01/27 14:46
 */
public class FindtheMiddleNodeOdd {
      public ListNode findMiddleNode(ListNode head) {
         // Write your solution here
         ListNode slow = head;
         ListNode fast = head;
         while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
         }
         return slow;
      }


}
