package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/06 17:02
 */
public class AllValidPermutationsOfParenthese2 {
   public List<String> validParentheses(int n) {
      // Write your solution here
      List<String> list = new ArrayList<>();
      if(n == 1){
         list.add("()");
         return list;
      }
      //必须有一个左括号才能有右括号
      //层数等于2n时结束
      int level = 0;
      int countLeft = 0;
      int countRight = 0;
      StringBuilder sb = new StringBuilder();
      list = validParentheses(n,list,level,sb,countLeft,countRight);
      return list;
   }
   private List<String> validParentheses(int n, List<String> list,int level,StringBuilder sb,int countLeft, int countRight){
      if(level == 2*n){
         list.add(sb.toString());
         return list;
      }
      if(countLeft < n){
         sb.append("(");
         list = validParentheses(n,list,level+1,sb,countLeft+1,countRight);
         sb.deleteCharAt(sb.length() - 1);
      }
      if(countLeft > countRight){
         sb.append(")");
         list = validParentheses(n,list,level+1,sb,countLeft,countRight+1);
         sb.deleteCharAt(sb.length() - 1);
      }

      return list;
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

