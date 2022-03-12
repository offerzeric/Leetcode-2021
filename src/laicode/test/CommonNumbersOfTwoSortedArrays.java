package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/10 15:11
 */
public class CommonNumbersOfTwoSortedArrays {
   public List<Integer> common(int[] A, int[] B) {
      // Write your solution here
      //# 1 who smaller move who
      //# 2 convert to hashMap A and B choose the min times of common one and put to result
      List<Integer> list = new ArrayList<Integer>();
      int i = 0;
      int j = 0;
      while(i < A.length && j < B.length){
         if(A[i] == B[j]){
            list.add(A[i]);
            i++;
            j++;
         }else if(A[i] < B[j]){
            i++;
         }else{
            j++;
         }
      }
      return list;
   }
}
