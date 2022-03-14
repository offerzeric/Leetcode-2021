package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/13 15:50
 */
public class Nqueues {
   public List<List<Integer>> nqueens(int n) {
      // Write your solution here
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      //cur level
      List<Integer> cur = new ArrayList<>();
      nqueens(n,cur,list);
      return list;
   }

   private void nqueens(int n, List<Integer> cur, List<List<Integer>> list){
      // one level put one basic case: when level == n add cur to list return back
      // sub: every level all the choice of item
      // recursion rule return list
      // cur row is index  value is choose which column
      if(cur.size() == n){
         list.add(new ArrayList<>(cur));
         return;
      }
      for(int i = 0; i < n; i++){
         if(validate(i,cur)){
            cur.add(i);
            nqueens(n,cur,list);
            cur.remove(cur.size() - 1);
         }
      }
   }

   private boolean validate(int col, List<Integer> cur){
      int row = cur.size();
      for(int i = 0; i < row; i++){
         if(cur.get(i) == col){
            return false;
         }
         if((cur.get(i) - i) == (col - row)){
            return false;
         }
         if((cur.get(i) + i) == (col + row)){
            return false;
         }
      }
      return true;
   }
}
