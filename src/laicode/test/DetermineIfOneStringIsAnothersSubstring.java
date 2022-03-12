package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/12 01:05
 */
public class DetermineIfOneStringIsAnothersSubstring {
   public int strstr(String large, String small) {
      // Write your solution here
      char[] la = large.toCharArray();
      char[] sa = small.toCharArray();
      if(small.length() == 0){
         return 0;
      }
      if(large.length() < small.length()){
         return -1;
      }
      for(int i = 0; i <= large.length() - small.length();i++){
         if(equals(la,i,sa)){
            return i;
         }
      }
      return -1;
   }
   private boolean equals(char[] la, int i, char[] sa){
      for(int start = 0; start < sa.length; start++){
         if(la[start + i] != sa[start]){
            return false;
         }
      }
      return true;
   }
}
