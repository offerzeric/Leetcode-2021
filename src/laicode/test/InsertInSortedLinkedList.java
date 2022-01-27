package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/27 14:51
 */
public class InsertInSortedLinkedList {
      public ListNode insert(ListNode head, int value) {
         // Write your solution here
         if(head == null){
            return new ListNode(value);
         }
         if(value < head.value){
            ListNode first = new ListNode(value);
            first.next = head;
            return first;
         }
         ListNode cur = head;
         ListNode tar = new ListNode(value);
         //找到合适的中间插入的位置  就是 pre<cur<tar<next时候插入
         while(cur.next != null && cur.next.value < tar.value){
            cur = cur.next;
         }
         tar.next = cur.next;
         cur.next = tar;
         return head;
      }

}
