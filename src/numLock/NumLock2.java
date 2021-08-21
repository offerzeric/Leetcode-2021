package numLock;

import org.junit.Test;

/**
 * try to reslove this by dp
 *
 * @author ericzhang 2021/08/19 2:05 下午
 */
public class NumLock2 {
    //定义一个函数用来解决该问题  要求的是不停的操作数组达到target的最小次数
    // dp返回到target的最小次数  1+ dp()最小次数
    String res = "0000";
    String target = "0009";
    String[] deadEnds = {"0010,0011"};
    String minusRes = "0000";
    String addRes = "0000";
    int step = 0;
    public int num(){
        if(addRes.equals(target) || minusRes.equals(target)){
            return step;
        }
        char[] chars = res.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //每一位的加减结果
            minusRes = minusOne(minusRes, i);
            int i1 = checkDead();
            addRes = addOne(addRes, i);
            int i2 = checkDead();
            if(i1 == -1 || i2 == -1){
                continue;
            }
            num();
            step++;
        }
        return step;
    }

    private int checkDead() {
        for (String deadEnd : deadEnds) {
            if(addRes.equals(deadEnd) || minusRes.equals(deadEnd)){
                return -1;
            }
        }
        return 0;
    }


    private String minusOne(String poll, int i1) {
        char[] chars = poll.toCharArray();
        if(chars[i1] == '0'){
            chars[i1] = '9';
        }else {
            chars[i1] -= 1;
        }
        return new String(chars);
    }

    private String addOne(String poll, int i1) {
        char[] chars = poll.toCharArray();
        if(chars[i1] == '9'){
            chars[i1] = '0';
        }else {
            //直接字符+1可以得到下一个字符型的数据
            chars[i1] += 1;
        }
        return new String(chars);
    }


    @Test
    public void test() {
        int num = num();
        System.out.println(num);
    }

}
