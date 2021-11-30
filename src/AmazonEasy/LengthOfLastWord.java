package AmazonEasy;

/**
 * description
 *
 * @author ericzhang 2021/11/29 11:24 下午
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int p = s.trim().length()-1;

        int length = 0;
        while(p >= 0 && s.trim().charAt(p) != ' '){
            p--;
            length++;
        }
        return length;
    }

}
