package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/02/15 18:01
 */
public class ArrayToStack {
   int head=-1;
   int size;
   Integer[] array;

   public ArrayToStack(int length){
      array = new Integer[length];
   }

   public boolean push(int element){
      if(head==array.length - 1){
         return false;
      }
      array[++head] = element;

      size++;
      return true;
   }

   public Integer pop(){
      if (head==-1){
         return null;
      }
      int temp = array[head--];
      size--;
      return temp;
   }

   public Integer peek(){
      if (head==-1){
         return null;
      }
      return array[head];
   }



}
