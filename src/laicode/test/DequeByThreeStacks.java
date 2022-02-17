package laicode.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * description
 *
 * @author ericzhang 2022/02/16 17:36
 */
public class DequeByThreeStacks {
   private Deque<Integer> left = new ArrayDeque();
   private Deque<Integer> right = new ArrayDeque();
   private Deque<Integer> buffer = new ArrayDeque();
   public DequeByThreeStacks() {
      // Write your solution here.
   }

   public void offerFirst(int element) {
      left.offerFirst(element);
   }

   public void offerLast(int element) {
      right.offerFirst(element);
   }

   public Integer pollFirst() {
      if(size() == 0){
         return null;
      }
      if(!left.isEmpty()){
         return left.pollFirst();
      }
      if(!right.isEmpty()){
         int times = 0;
         while(!right.isEmpty() && times < right.size() / 2){
            buffer.offerFirst(right.pollFirst());
            times++;
         }
         while(!right.isEmpty()){
            left.offerFirst(right.pollFirst());
         }
         while(!buffer.isEmpty()){
            right.offerFirst(buffer.pollFirst());
         }
         return left.pollFirst();
      }
      return null;
   }

   public Integer pollLast() {
      if(size() == 0){
         return null;
      }
      if(!right.isEmpty()){
         return right.pollFirst();
      }
      if(!left.isEmpty()){
         int times = 0;
         while(!left.isEmpty() && times < left.size() / 2){
            buffer.offerFirst(left.pollFirst());
            times++;
         }
         while(!left.isEmpty()){
            right.offerFirst(left.pollFirst());
         }
         while(!buffer.isEmpty()){
            left.offerFirst(buffer.pollFirst());
         }
         return right.pollFirst();
      }
      return null;
   }

   public Integer peekFirst() {
      if(size() == 0){
         return null;
      }
      if(!left.isEmpty()){
         return left.peekFirst();
      }
      if(!right.isEmpty()){
         int times = 0;
         while(!right.isEmpty() && times < right.size() / 2){
            buffer.offerFirst(right.pollFirst());
            times++;
         }
         while(!right.isEmpty()){
            left.offerFirst(right.pollFirst());
         }
         while(!buffer.isEmpty()){
            right.offerFirst(buffer.pollFirst());
         }
         return left.peekFirst();
      }
      return null;
   }

   public Integer peekLast() {
      if(size() == 0){
         return null;
      }
      if(!right.isEmpty()){
         return right.peekFirst();
      }
      if(!left.isEmpty()){
         int times = 0;
         while(!left.isEmpty() && times < left.size() / 2){
            buffer.offerFirst(left.pollFirst());
            times++;
         }
         while(!left.isEmpty()){
            right.offerFirst(left.pollFirst());
         }
         while(!buffer.isEmpty()){
            left.offerFirst(buffer.pollFirst());
         }
         return right.peekFirst();
      }
      return null;
   }

   public int size() {
      return left.size() + right.size();
   }

   public boolean isEmpty() {
      return left.isEmpty() && right.isEmpty();
   }
}
