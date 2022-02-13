package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/12 20:34
 */
public class ReOrderLinkedList {
   public ListNode reorder(ListNode head) {
      // Write your solution here
      if(head == null || head.next == null || head.next.next == null){
         return head;
      }
      ListNode midValue = findMid(head);
      ListNode temp = midValue.next;
      midValue.next = null;
      ListNode res = reverse(temp);
      ListNode result = merge(res,head);
      return result;
   }

   private ListNode findMid(ListNode head){
      ListNode fast = head;
      ListNode slow = head;
      while(fast.next != null && fast.next.next != null){
         slow = slow.next;
         fast = fast.next.next;
      }
      return slow;
   }
   private ListNode reverse(ListNode head){
      if(head == null){
         return head;
      }
      ListNode pre = null;
      ListNode next = null;
      while(head != null){
         next = head.next;
         head.next = pre;
         pre = head;
         head = next;  //错误没用保存的next
      }
      return pre;
   }

   private ListNode merge(ListNode mid, ListNode head){
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      while(mid != null && head != null){
         cur.next = head;
         head = head.next;
         cur = cur.next;
         cur.next = mid;
         mid = mid.next;
         cur = cur.next; //错误漏写
      }
      if(head != null){
         cur.next = head;
      }
      if(mid != null){
         cur.next = mid;
      }
      return dummy.next;
   }
}
