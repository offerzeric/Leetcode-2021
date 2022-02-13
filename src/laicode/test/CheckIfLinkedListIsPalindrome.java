package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/13 14:58
 */
public class CheckIfLinkedListIsPalindrome {
   public boolean isPalindrome(ListNode head) {
      if(head == null || head.next == null){
         return true;
      }
      // Write your solution here
      //first findMid revese second check same
      ListNode mid = findMid(head);
      ListNode second = mid.next;
      mid.next = null;
      ListNode res = reverse(second);
      return checkSame(head,res);
   }
   private ListNode reverse(ListNode head){
      if(head.next == null){
         return head;
      }
      ListNode pre = null;
      ListNode next = null;
      while(head != null){
         next = head.next;
         head.next = pre;
         pre = head;
         head = next;
      }
      return pre;
   }
   private boolean checkSame(ListNode head, ListNode second){
      while(head != null && second != null){
         if(head.value != second.value){
            return false;
         }
         head = head.next;
         second = second.next;
      }
      return true;
   }
   private ListNode findMid(ListNode head){
      ListNode fast = head;
      ListNode slow = head;
      while(fast.next != null && fast.next.next != null){
         fast = fast.next.next;
         slow = slow.next;
      }
      return slow;
   }


}
