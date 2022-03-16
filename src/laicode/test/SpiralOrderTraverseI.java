package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/15 14:38
 */
public class SpiralOrderTraverseI {
   public List<Integer> spiral(int[][] matrix) {
      // Write your solution here
      // base case
      //1. if n is even there is no point in middle
      //2. if n is odd there will be a point left
      //sub: 不停的旋转打印 减少的打印的正方形的size
      //recursion rule put all the elements into list
      //每一个都要有offset
      List<Integer> list = new ArrayList<Integer>();
      int size = matrix.length;
      int offset = 0;
      spiral(list,size,offset,matrix);
      return list;
   }

   private void spiral(List<Integer> list,int size,int offset,int[][] matrix){
      if(size == 0){
         return;
      }
      if(size == 1){
         list.add(matrix[offset][offset]);
         return;
      }
      for(int i = 0; i < size - 1; i++){
         list.add(matrix[offset][offset+i]);
      }
      for(int i = 0; i < size - 1; i++){
         list.add(matrix[i+offset][offset+ size - 1]);
      }
      for(int i = size - 1; i >= 1; i--){
         list.add(matrix[offset + size - 1][i+offset]);
      }
      for(int i = size - 1; i >= 1; i--){
         list.add(matrix[offset+i][offset]);
      }
      spiral(list,size - 2,offset+1,matrix);
   }
}
