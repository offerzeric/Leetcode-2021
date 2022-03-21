package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/20 22:45
 */
public class midterm2printParentess {
   public void print(int n){
      List<String> list = new ArrayList<String>();
      StringBuilder sb = new StringBuilder();
      int countL = 0;
      int countR = 0;
      print(sb,n,list,countL, countR);
   }
   private void print(StringBuilder sb, int n, List<String> list, int countL, int countR){
      if(sb.length() == 2*n){
         sb.append("}");
         printBlock(sb.toString().toCharArray());
         sb.deleteCharAt(sb.length() - 1);
      }
      if(countL < n){
         sb.append("{");
         print(sb,n,list,countL+1,countR);
         sb.deleteCharAt(sb.length() - 1);
      }
      if(countR < countL){
         sb.append("}");
         print(sb,n,list,countL,countR+1);
         sb.deleteCharAt(sb.length() - 1);
      }
   }

   private void printBlock(char[] curr) {
      int space = 0;
      for (int i = 0; i < curr.length; i++) {
         if (curr[i] == '{') {
            printSpace(space);
            System.out.println("if {");
            space += 2;
         } else {
            space -= 2;
            printSpace(space);
            System.out.println("}");
         }
      }
      System.out.println();
   }

   private void printSpace(int n) {
      while (n > 0) {
         System.out.print(" ");
         n--;
      }
   }
}
