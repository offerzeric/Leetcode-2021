package laicode.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * description
 *
 * @author ericzhang 2022/02/16 17:05
 */
public class StackbyOneQueue {
   private Queue<Integer> values = new ArrayDeque();
   int size = 0;
   /** Initialize your data structure here. */
   public StackbyOneQueue() {

   }

   /** Push element x onto stack. */
   public void push(int x) {
      values.offer(x);
      size++;
   }

   /** Removes the element on top of the stack and returns that element. */
   public Integer pop() {
      if(values.isEmpty()){
         return null;
      }
      int temp = 0;
      while(temp < values.size()-1){
         values.offer(values.poll());
         temp++;
      }
      size--;
      return values.poll();
   }

   /** Get the top element. */
   public Integer top() {
      if(values.isEmpty()){
         return null;
      }
      int temp = 0;
      while(temp < values.size()-1){
         values.offer(values.poll());
         temp++;
      }
      int res = values.peek();
      values.offer(values.poll());
      return res;
   }

   /** Returns whether the stack is empty. */
   public boolean isEmpty() {
      return values.isEmpty();
   }

}
