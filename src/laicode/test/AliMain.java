package laicode.test;

import java.util.*;

/**
 * description
 *
 * @author ericzhang 2022/03/24 18:37
 */
public class AliMain {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int times = 0;
      while (sc.hasNext()) {
         times = sc.nextInt();
      }
      ArrayList<Integer> list = new ArrayList<>();
      Integer item = 0;
      Integer flag = 0;
      for (int i = 0; i < times; i++) {
         while (sc.hasNext() && flag < 5) {
            item = sc.nextInt();
            flag += 1;
            list.add(item);
         }
         check(list);
         flag = 0;
         list.clear();
      }
   }

   private static void check(ArrayList<Integer> list) {
      int times = 0;
      int i = 0;
      int j = 3;
      while (valid(list, i, j)) {
         for (int index = i; index <= j; index++) {
            list.set(index, list.get(index) - 1);
         }
         times++;
         if(!valid(list,i,j) && j < 4){
            j+=1;
         }else if(i < 1 &&!valid(list,i,j)) {
            i+=1;
         }else{
            System.out.println(times);
            times=0;
            break;
         }
      }


   }

   private static boolean valid(ArrayList<Integer> list, int i, int j) {
      for (int k = i; k <= j; k++) {
         if (list.get(k) <= 0) {
            return false;
         }
      }
      return true;
   }


}



