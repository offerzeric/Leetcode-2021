package laicode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/06 17:02
 */
public class AllValidPermutationsOfParenthese2 {
   public List<String> validParentheses(int l, int m, int n) {
      // Write your solution here
      // ( cannot exist more than the number of i
      // < cannot exist more than the number of m
      // { cannot exist more than number of n
      // first ( then )
      //the last level is 2I + 2m + 2n we add one of three then return
      //遇到left put in stack
      // meet with right check stack:1.stack empty cannot add ) 2.stack has ele (1) stack is pair ele add (2) stack is not pair not add
      int countSmal = 0;
      int countMidl = 0;
      int countBigl = 0;
      List<String> list = new ArrayList<String>();
      StringBuilder sb = new StringBuilder();
      Deque<String> stack = new ArrayDeque<>();
      validParentheses(l, m, n, countSmal, countMidl, countBigl, sb, list, stack);
      return list;
   }

   //return in this situation the all permutations
   private void validParentheses(int l, int m, int n, int countSmal, int countMidl, int countBigl, StringBuilder sb, List<String> list, Deque<String> stack) {
      if (sb.length() == 2 * l + 2 * n + 2 * m) {
         list.add(sb.toString());
         return;
      }
      if (countSmal < l) {
         stack.offerLast("(");
         sb.append("(");
         validParentheses(l, m, n, countSmal + 1, countMidl, countBigl, sb, list, stack);
         stack.pollLast();
         sb.deleteCharAt(sb.length() - 1);
      }
      if (countMidl < m) {
         stack.offerLast("<");
         sb.append("<");
         validParentheses(l, m, n, countSmal, countMidl + 1, countBigl, sb, list, stack);
         stack.pollLast();
         sb.deleteCharAt(sb.length() - 1);
      }
      if (countBigl < n) {
         stack.offerLast("{");
         sb.append("{");
         validParentheses(l, m, n, countSmal, countMidl, countBigl + 1, sb, list, stack);
         stack.pollLast();
         sb.deleteCharAt(sb.length() - 1);
      }

      if (!stack.isEmpty() && stack.peekLast() == "(") {
         stack.pollLast();
         sb.append(")");
         validParentheses(l, m, n, countSmal, countMidl, countBigl, sb, list, stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.offerLast("(");
      }
      if (!stack.isEmpty() && stack.peekLast() == "<") {
         stack.pollLast();
         sb.append(">");
         validParentheses(l, m, n, countSmal, countMidl, countBigl, sb, list, stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.offerLast("<");
      }
      if (!stack.isEmpty() && stack.peekLast() == "{") {
         stack.pollLast();
         sb.append("}");
         validParentheses(l, m, n, countSmal, countMidl, countBigl, sb, list, stack);
         sb.deleteCharAt(sb.length() - 1);
         stack.offerLast("{");
      }
   }
}







// 						            {}
// 					           /    \
// 					          (
// 					      /      \
//   					  (          )
// 					   / \        / \
// 					 (     )     (
// 					  \    /\    /\
// 				    )  (    )
// so each level we add a ( or a ) if there is no ( before we just can add (
// 			              else we can add ）
// 2n level
// every level we determine whether we add ( or )
// base case: when ( number == n we stop also ) number need to equals n

