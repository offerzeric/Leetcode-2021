package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/13 14:21
 */
public class MergeSortLinkedList {
   public ListNode mergeSort(ListNode head) {
      // Write your solution here base && coner
      if(head == null || head.next == null){
         return head;
      }
      // first find the mid the cut off the two linked list into two parts then merge
      ListNode mid = findMid(head);
      ListNode second = mid.next;
      mid.next = null;
      ListNode left = mergeSort(head);
      ListNode right = mergeSort(second);
      return merge(left,right);
   }
   private ListNode merge(ListNode left, ListNode right){
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      while(left != null && right != null){
         if(left.value < right.value){
            cur.next = left;
            left = left.next;
         }else{
            cur.next = right;
            right = right.next;
         }
         cur = cur.next;
      }
      if(left != null){
         cur.next = left;
      }
      if(right != null){
         cur.next = right;
      }
      return dummy.next;
   }
   private ListNode findMid(ListNode head){
      ListNode fast = head;
      ListNode slow = head;
      while(fast.next!=null && fast.next.next != null){
         fast = fast.next.next;
         slow = slow.next;
      }
      return slow;
   }
}
