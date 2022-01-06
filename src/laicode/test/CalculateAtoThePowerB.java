package laicode.test;

import org.junit.Test;

/**
 * description
 *
 * @author ericzhang 2022/01/05 09:44
 */
public class CalculateAtoThePowerB {
    public int power(int a, int b) {
        int res = 1;
        // Write your solution here
        for(int i=1;i<=b;i++){
            res= res*a;
        }
        return res;
    }

    @Test
    public void test(){
        int power = power(2, 2);
        System.out.println(power);
    }
}

