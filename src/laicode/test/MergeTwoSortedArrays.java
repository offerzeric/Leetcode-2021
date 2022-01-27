package laicode.test;

/**
 * 合并多半是比较两个容器的值进行大小比较 插入完一个以后把另一个剩余的搬上去
 *
 * @author ericzhang 2022/01/27 14:40
 */
public class MergeTwoSortedArrays {
      public int[] merge(int[] one, int[] two) {
         int i=0,j=0,k=0;
         int[] res = new int[one.length+two.length];
         while(i<one.length && j<two.length){
            if(one[i] < two[j]){
               res[k] = one[i];
               k++;
               i++;
            }else{
               res[k] = two[j];
               j++;
               k++;
            }
         }
         if(i<one.length){
            while(i<one.length){
               res[k++] = one[i++];
            }
         }

         if(j<two.length){
            while(j<two.length){
               res[k++] = two[j++];
            }
         }
         return res;
      }
}
