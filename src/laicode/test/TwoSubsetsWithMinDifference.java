package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/29 13:43
 */
public class TwoSubsetsWithMinDifference {
   public static int minDifference(int[] array) {
      // Write your solution here
      // diff of sum of two subsets need to be minimun which means the sum needs to be 1/2 c
      // find all the subsets of n/2 sizes
      // check the difference
      // TC is (2^n + n) SC is O(n)
      List<List<Integer>> list = new ArrayList<>();
      List<Integer> cur = new ArrayList<>();
      int index = 0;
      int length = array.length;
      int subLength = length / 2;
      int gloMin = Integer.MAX_VALUE;
      int lastSum = 0;
      minDifference(array,index,subLength,cur,list);
      //every item store the index of the subsets elements
      for(List<Integer> item : list){
         lastSum = checkLastIndex(item,array);
         int sum = 0;
         for(Integer para : item){
            sum+= array[para];
         }
         int diff = Math.abs(lastSum - sum);
         if(diff < gloMin){
            gloMin = diff;
         }
      }
      return gloMin;
   }
   private static void minDifference(int[] array,int index,int subLength, List<Integer> cur, List<List<Integer>> list){
      if(index == array.length && cur.size() == subLength){
         list.add(new ArrayList<>(cur));
         return;
      }
      if(index == array.length){
         return;
      }
      cur.add(index);
      minDifference(array,index+1,subLength,cur,list);
      cur.remove(cur.size() - 1);
      minDifference(array,index+1,subLength,cur,list);
   }
   private static int checkLastIndex(List<Integer> item,int[] array){
      int sum = 0;
      int index = 0;
      while(index <= array.length - 1){
         if(item.contains(index)){
            index++;
            continue;
         }else{
            sum += array[index];
         }
         index++;
      }
      return sum;
   }

   public static void main(String[] args) {
      int[] ints = {1, 2, 3, 4};
      int i = minDifference(ints);

   }
}
