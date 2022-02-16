package laicode.test;

import java.util.LinkedList;

/**
 Field: head, size, tail
 Method: offer, poll, peek, size
 void offer(int ele)
 Integer poll()
 Integer peek()
 Integer size()

 * @author ericzhang 2022/02/15 17:23
 */

public class LinkedListToQueue {
   private ListNode head;
   private ListNode tail;
   private int size;

   private LinkedList<Integer> list = new LinkedList<>();

   public LinkedListToQueue(){
      this.size = 0;
      head = null;
      tail = null;
   }
   private void offer(int ele){
      if(head == null){
         head = new ListNode(ele);
         tail = head.next;
      }else {
         tail = new ListNode(ele);
         tail = tail.next;
      }
      size++;
   }

   private Integer poll(){
      if(head == null){
         return null;
      }
      int res = head.value;
      head = head.next;
      size--;
      return res;
   }

   private Integer peek(){
      if(head == null){
         return null;
      }
      return head.value;
   }

}
