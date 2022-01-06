package laicode.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/01/05 12:15
 */
public class SumofSquares {

    public int sumOfSquare(List<Integer> list) {
        // Write your solution here
        int res = 0;
        if(list == null||list.size()==0){
            return 0;
        }else{
            for(int i=0;i<list.size();i++){
                Integer integer = list.get(i);
                res+=Math.pow(integer,2);
            }
            return res;
        }
    }

    @Test
    public void test(){
        List<Integer>  list = Arrays.asList(1);
        sumOfSquare(list);
    }

}
