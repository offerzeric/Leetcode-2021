package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/31 20:49
 */
public class FactorCombinations {
   public List<List<Integer>> combinations(int target) {
      // Write your solution here
      // get factories
      // for each level we put one factor each level can use all factors and each level we try every possible nums of this chooise
      List<List<Integer>> list = new ArrayList<>();
      List<Integer> cur = new ArrayList<>();
      if(target == 0){
         return list;
      }
      List<Integer> factor = getFactor(target);
      int index = 0;
      combinations(index,target,factor,cur,list);
      return list;
   }
   private void combinations(int index, int target,List<Integer> factor,List<Integer> cur, List<List<Integer>> list){
      if(index == factor.size()){
         if(target == 1){
            list.add(new ArrayList<>(cur));
         }
         return;
      }
      combinations(index+1,target,factor,cur,list);
      int coin = factor.get(index);
      int count = 0;
      while(target % coin == 0){
         cur.add(coin);
         count++;
         target /= coin;
         combinations(index+1,target,factor,cur,list);
      }
      for(int i = 0; i < count; i++){
         cur.remove(cur.size() - 1);
      }
   }
   private List<Integer> getFactor(int target){
      List<Integer> factor = new ArrayList<>();
      for(int i = target / 2; i > 1; i--){
         if(target % i == 0){
            factor.add(i);
         }
      }
      return factor;
   }
}
