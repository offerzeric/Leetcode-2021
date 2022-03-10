package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/09 16:00
 */
public class CombinationsOfCoins {
   public List<List<Integer>> combinations(int target, int[] coins) {
      // Write your solution here
      // every level choose one coin to cannot choose anymore
      // array.length = level
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      if(target == 0 || coins.length == 0){
         return list;
      }
      List<Integer> param = new ArrayList<>();
      int index = 0;
      int level = 1;
      combinations(list,target,coins,param,index,level);
      return list;
   }

   private void combinations(List<List<Integer>> list, int target, int[] coins, List<Integer> param,int index,int level){
      if(level == coins.length){
         if(target % coins[index] == 0){
            param.add(target / coins[index]);
            list.add(new ArrayList<Integer>(param));
            param.remove(param.size() - 1);
         }
         return;
      }
      int max = target / coins[index];
      for(int i = 0; i <= max; i++){
         param.add(i);
         combinations(list,target - i*coins[index],coins,param,index+1,level+1);
         param.remove(param.size() - 1);
      }
   }

}
