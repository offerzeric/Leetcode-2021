package laicode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/29 00:29
 */
public class AllValidPermutationsOfParenthesesIII {
   public List<String> validParenthesesIII(int l, int m, int n) {
      // Write your solution here
      List<String> list = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      int countS = 0;
      int countM = 0;
      int countL = 0;
      Deque<String> deque = new ArrayDeque<>();
      //怎么体现priority：放小的之前前面要是大的
      validParenthesesIII(l,m,n,list,sb,countS, countM, countL,deque);
      return list;
   }
   private void validParenthesesIII(int l, int m, int n, List<String> list, StringBuilder sb, int countS,int countM,int countL,Deque<String> stack){
      if(sb.length() == 2*l+2*m+2*n){
         list.add(sb.toString());
         return;
      }
      if(countS < l && (stack.isEmpty() || stack.peekLast() == ")" || stack.peekLast() == "<" || stack.peekLast() == ">" || stack.peekLast() == "{" || stack.peekLast() == "}")){
         stack.offerLast("(");
         sb.append("(");
         validParenthesesIII(l,m,n,list,sb,countS+1,countM,countL,stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.pollLast();
      }
      if(countM < m && (stack.isEmpty() || stack.peekLast() == ">" || stack.peekLast() == "{" || stack.peekLast() == "}")){
         stack.offerLast("<");
         sb.append("<");
         validParenthesesIII(l,m,n,list,sb,countS,countM+1,countL,stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.pollLast();
      }
      if(countL < n && (stack.isEmpty() || stack.peekLast()=="}")){
         stack.offerLast("{");
         sb.append("{");
         validParenthesesIII(l,m,n,list,sb,countS,countM,countL+1,stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.pollLast();
      }
      if(!stack.isEmpty() && stack.peekLast() == "("){
         stack.pollLast();
         sb.append(")");
         validParenthesesIII(l,m,n,list,sb,countS,countM,countL,stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.offerLast("(");
      }
      if(!stack.isEmpty() && stack.peekLast() == "<"){
         stack.pollLast();
         sb.append(">");
         validParenthesesIII(l,m,n,list,sb,countS,countM,countL,stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.offerLast("<");
      }
      if(!stack.isEmpty() && stack.peekLast() == "{"){
         stack.pollLast();
         sb.append("}");
         validParenthesesIII(l,m,n,list,sb,countS,countM,countL,stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.offerLast("{");
      }
   }
}
