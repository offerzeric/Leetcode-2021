package easy;

/**
 *  取出第一个字母去比较 再取出第二....
 *  如果是空数组则返回为0
 *
 * @author ericzhang 2021/08/13 11:21 上午
 */
public class ImpleStr_28 {
    public int strStr(String haystack, String needle) {
            if(needle.isEmpty()){
                    return 0;
            }else if(!haystack.contains(needle)){
                return -1;
            }else {
                return haystack.indexOf(needle);
            }
    }
}
