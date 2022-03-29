package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/29 14:21
 */
public class AllPermutationsofSubsets {
   public List<String> allPermutationsOfSubsets(String set) {
      // Write your solution here
      // we can calculate the subsets and then get all the permutations of subsets but stupid
      // so we can get the subsets when we get permutatios at the same time
      // TC is O(n*!) SC is o(n)
      List<String> list = new ArrayList<String>();
      int index = 0;
      char[] in = set.toCharArray();
      allPermutationsOfSubsets(list,index,in);
      return list;
   }
   private void allPermutationsOfSubsets(List<String> list,int index, char[] in){
      list.add(new String(in,0,index));
      for(int i = index; i < in.length;i++){
         swap(in,i,index);
         allPermutationsOfSubsets(list,index+1,in);
         swap(in,i,index);
      }

   }
   private void swap(char[] in, int i, int index){
      char temp = in[i];
      in[i] = in[index];
      in[index] = temp;
   }
}
