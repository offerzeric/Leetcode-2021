package CS455Lab;

import java.util.Scanner;

/**
 * description
 *
 * @author ericzhang 2022/02/22 23:29
 */
public class LongestStringInWords {
   public static  int longestWordLen(String words) {
      Scanner sc = new Scanner(words);
      return longestWordLenHelper(sc);
   }

   private static int longestWordLenHelper(Scanner sc){
      if(!sc.hasNext()){
         return 0;
      }
      String item = sc.next();
      int lengthCompare = longestWordLenHelper(sc);
      return Math.max(item.length(), lengthCompare);
   }

   public static void main(String[] args) {
      String words = "What is the longest word";
      int i = longestWordLen(words);
      System.out.println(i);
   }

}
