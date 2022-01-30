package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/29 23:10
 */
public class PartitionLinkedList {
   public ListNode partition(ListNode head, int target) {
      // Write your solution here
      ListNode pre = new ListNode(0);
      ListNode resPre = pre;
      ListNode post = new ListNode(0);
      ListNode resPost = post;
      ListNode curr = head;
      while(curr != null){
         if(curr.value < target){
            pre.next = curr;
            pre = pre.next;
         }else{
            post.next = curr;
            post = post.next;
         }
         curr = curr.next;
      }
      post.next = null;
      pre.next = resPost.next;
      return resPre.next;
   }
}
