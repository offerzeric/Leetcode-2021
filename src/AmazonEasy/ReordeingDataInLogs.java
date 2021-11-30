package AmazonEasy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * description
 *
 * @author ericzhang 2021/11/29 7:01 下午
 */
public class ReordeingDataInLogs {

    private ArrayList<String> digits = new ArrayList<>();
    private ArrayList<String> letters = new ArrayList<>();
    private String[] res = new String[10];
    //letter
    //x1 < x2   x1放前面
    //x1 = x2   比较第一个字母
    //x1 > x2   x2放前面
    Comparator <String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);
            boolean digit1 = Character.isDigit(s1[1].charAt(0));
            boolean digit2 = Character.isDigit(s2[1].charAt(0));

            if(digit1==Boolean.TRUE && digit2==Boolean.TRUE){
                return 0;
            }else if(!digit1 && digit2){
                return -1;
            }else  if(digit1 && !digit2){
                return 1;
            }else if(!digit1 && !digit2){
                int compare = Character.compare(s1[1].charAt(0), s2[1].charAt(0));
                if(compare  != 0){
                    return compare;
                }
                return Character.compare(s1[0].charAt(0), s2[0].charAt(0));
            }
            return 0;
        }
    };

}
