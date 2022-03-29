package laicode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/29 11:58
 */
public class AllSubsetsIIofSizeK {
   public static List<String> subSetsIIOfSizeK(String set, int k) {
      // Write your solution here
      // for each level we choose whether we add a item
      // when the index get to the set.length we return
      // we only calculate the size k result
      // TC n length of set so TC is o(2^n) SC o(n)
      List<String> list = new ArrayList<String>();
      StringBuilder sb = new StringBuilder();
      if(set.length() == 0 && k == 0){
         list.add("");
         return list;
      }
      if(set.length() == 0 && k == 1 || set == null && k == 0){
         return list;
      }
      int index = 0;
      char[] in = set.toCharArray();
      Arrays.sort(in);
      subSetsIIOfSizeK(list,sb,index,in,k);
      return list;
   }
   private static void subSetsIIOfSizeK(List<String> list,StringBuilder sb,int index, char[] in,int k){
      if(index == in.length && sb.length() == k){
         list.add(sb.toString());
         return;
      }
      if(index == in.length){
         return;
      }
      sb.append(in[index]);
      subSetsIIOfSizeK(list,sb,index+1,in,k);
      sb.deleteCharAt(sb.length() - 1);
      while(index < in.length - 1 && in[index+1] == in[index]){
         index += 1;
      }
      subSetsIIOfSizeK(list,sb,index+1,in,k);
   }

   public static void main(String[] args) {
      String set = "abc";
      int k = 2;
      subSetsIIOfSizeK(set,k);
   }
}
