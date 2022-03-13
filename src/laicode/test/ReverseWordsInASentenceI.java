package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/12 13:27
 */
public class ReverseWordsInASentenceI {
   public static String reverseWords(String input) {
      // Write your solution here
      // reverse the whole sentence first
      // reverse the item seperately
      char[] array = input.toCharArray();
      int i = 0;
      int j = array.length - 1;
      swap(array,i,j);
      int start = 0;
      for(int in = 0; in < array.length; in++){
         if(array[in] == ' '){
            swap(array,start,in-1);
            start = in+1;
         }
         if(in == array.length - 1 && array[in] != ' '){
            swap(array,start,in);
         }
      }
      return new String(array);
   }
   private static void swap(char[] array,int i,int j){
      while(i < j){
         char temp = array[i];
         array[i] = array[j];
         array[j] = temp;
         i++;
         j--;
      }
   }

   public static void main(String[] args) {
      String in = "an apple";
      reverseWords(in);
   }
}
