package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/31 23:36
 */
public class CombinationsForTelephonePadI {
   public String[] combinations(int number) {
      // Write your solution here
      List<String> list = new ArrayList<>();
      char[] in = Integer.toString(number).toCharArray();
      String[] base = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      int index = 0;
      StringBuilder sb = new StringBuilder();
      combinations(index,in,list,base,sb);
      return list.toArray(new String[0]);
   }
   private void combinations(int index,char[] in, List<String> list,String[] base,StringBuilder sb){
      if(index == in.length){
         list.add(sb.toString());
         return;
      }
      String item = base[in[index]-'0'];
      if(item.length() == 0){
         combinations(index+1,in,list,base,sb);
      }else{
         for(int i = 0; i < item.length(); i++){
            sb.append(item.charAt(i));
            combinations(index+1,in,list,base,sb);
            sb.deleteCharAt(sb.length() - 1);
         }
      }
   }
}
