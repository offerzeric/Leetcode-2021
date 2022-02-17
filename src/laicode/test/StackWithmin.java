package laicode.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * description
 *
 * @author ericzhang 2022/02/02 18:17
 */
public class StackWithmin {
   private Deque<Integer> value = new ArrayDeque();
   private Deque<Integer>  minSize = new ArrayDeque();
   private Deque<Integer>  minVal = new ArrayDeque();

   public int pop() {
      if(value.isEmpty()){
         return -1;
      }
      int ele = value.pollFirst();
      if(minVal.peekFirst() == ele){
         if(minSize.peekFirst() == value.size()+1){
            minVal.pollFirst();
            minSize.pollFirst();
         }
      }
      return ele;
   }

   public void push(int element) {
      value.offerFirst(element);
      if(minVal.isEmpty() || element < minVal.peekFirst()){
         minSize.offerFirst(value.size());
         minVal.offerFirst(element);
      }
   }

   public int top() {
      if(value.size() == 0){
         return -1;
      }
      return value.peekFirst();
   }

   public int min() {
      if(minVal.isEmpty()){
         return -1;
      }
      return minVal.peekFirst();
   }
}
