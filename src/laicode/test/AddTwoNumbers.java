package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/13 15:23
 */
public class AddTwoNumbers {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if(l1 == null && l2 == null){
         return null;
      }
      // Write your solution here
      //calculate
      //rever again
      ListNode dummy = new ListNode(0);
      ListNode res = dummy;
      int val = 0;
      while(l1 != null || l2 != null || val != 0){
         if(l1 != null){
            val += l1.value;
            l1 = l1.next;
         }
         if(l2 != null){
            val += l2.value;
            l2 = l2.next;
         }
         int mod = val % 10;
         res.next = new ListNode(mod);
         res = res.next;
         val = val / 10;
      }
      return dummy.next;
   }
   // private ListNode reverse(ListNode head){
   //   ListNode pre = null;
   //   ListNode next = null;
   //   while(head != null){
   //     next = head.next;
   //     head.next = pre;
   //     pre = head;
   //     head = next;
   //   }
   //   return pre;
   // }
}
