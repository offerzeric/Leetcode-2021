package laicode.test;

import java.util.*;

/**
 * description
 *
 * @author ericzhang 2022/02/13 16:00
 */
public class Test {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      ArrayList arrayList = new ArrayList(100);
      Map<Integer, Integer> map = new HashMap<>();
      Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
      String score = "";
      while (!score.equals("s")) {
         score = scanner.next();
         arrayList.add(score);
      }
      System.out.println(arrayList);
   }
}
