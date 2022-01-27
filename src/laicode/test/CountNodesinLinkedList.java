package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/27 14:42
 */
public class CountNodesinLinkedList {

   /**
    * class ListNode {
    *   public int value;
    *   public ListNode next;
    *   public ListNode(int value) {
    *     this.value = value;
    *     next = null;
    *   }
    * }
    */
      public int count(ListNode head) {
         // Write your solution here
         ListNode temp = head;
         int counter = 1;
         while(temp.next != null){
            temp = temp.next;
            counter++;
         }
         return counter;
      }


}
