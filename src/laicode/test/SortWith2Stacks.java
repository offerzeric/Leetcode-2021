package laicode.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * description
 *
 * @author ericzhang 2022/02/16 15:56
 */
public class SortWith2Stacks {
   private Deque<Integer> stack1 = new ArrayDeque();
   private Deque<Integer> stack2 = new ArrayDeque();
   private int size = 0;
   public SortWith2Stacks() {
      // stack1是用来存储的
      // stack2是用来拿出的
   }

   public Integer poll() {
      if(!stack2.isEmpty()){
         size--;
         return stack2.pollFirst();
      }else{
         if(stack1.isEmpty()){
            return null;
         }else{
            daoTeng();
            size--;
            return stack2.pollFirst();
         }
      }
   }

   public void offer(int element) {
      stack1.offerFirst(element);
      size++;
   }

   public Integer peek() {
      if(!stack2.isEmpty()){
         return stack2.peekFirst();
      }else{
         if(stack1.isEmpty()){
            return null;
         }else{
            daoTeng();
            return stack2.peekFirst();
         }
      }
   }

   public int size() {
      return size;
   }

   public boolean isEmpty() {
      return size==0?true:false;
   }
   private void daoTeng(){
      while(!stack1.isEmpty()){
         stack2.offerFirst(stack1.pollFirst());
      }
   }
}
