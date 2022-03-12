package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/03/11 17:25
 */
public class RemoveSpaces {
   public String removeSpaces(String input) {
      // Write your solution here
      char[] array = input.toCharArray();
      int slow = 0;
      for(int fast = 0;fast < array.length; fast++){
         if(fast == 0 && array[fast] == ' '){
            continue;
         }else if(fast == array.length-1 && array[fast]==' '){
            continue;
         }else if(array[fast] == ' ' && array[fast-1] == ' '){
            continue;
         }else{
            array[slow++] = array[fast];
         }
      }
      if(slow > 0 && array[slow - 1] == ' '){
         slow--;
      }
      return new String(array,0,slow);
   }
}
