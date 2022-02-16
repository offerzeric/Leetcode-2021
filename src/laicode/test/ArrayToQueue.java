package laicode.test;

/**
 * → field:
 * array, head, tail, size
 * → method:
 * void offer(int ele)
 * Integer poll()
 * Integer peek()
 * Integer size()
 *
 * @author ericzhang 2022/02/15 17:42
 */
public class ArrayToQueue {
   private int[] array;
   private int head;
   private int tail;
   private  int size;

   public ArrayToQueue(){
      this.array =  new int[10];
      this.head = 0;
      this.tail = 0;
      this.size = 0;
   }
   public void offer(int ele){
      if(size == 10){
         return;
      }
      array[tail] = ele;
      tail = tail+1 == array.length?0:tail+1;
      size++;
   }

   public Integer poll(){
      if(size == 0){
         return null;
      }
      int res = array[head];
      head = head+1 == array.length?0:head+1;
      size--;
      return res;
   }

   public Integer peek(){
      if(size == 0){
         return null;
      }
      return array[head];
   }

   public Integer size(){
      return size;
   }

}
