package fib;

import org.junit.Test;

/**
 * DP
 *
 * @author ericzhang 2021/08/14 8:34 上午
 */
public class Fib {

    //base case f0 = 0    f1 = 1
    //for
    //dp
    public int fibReverse(int N){
        //base case
        if((N==0) || (N==1)){
            return N;
        }else {
            //dp
            return fibReverse(N-1) + fibReverse(N-2);
        }
    }

    public void run(){
        int i = fibReverse(4);
        System.out.println(i);
    }

    //base case f0 = 0    f1 = 1
    //for
    //dp
    public int fibReverseMem(int[] mem,int N){
        //base case
        if((N==0) || (N==1)){
            return N;
        }else {
            //dp
            if (mem[N] != -1) {
                return mem[N];
            }
            mem[N] = fibReverseMem(mem,N-1) + fibReverseMem(mem,N-2);
            return mem[N];
        }
    }

    public void runMem(){
        int[] mem = {-1,-1,-1,-1,-1};
        int i = fibReverseMem(mem, 4);
        System.out.println(i);
    }


    public int fibReverseLinear(int N){
        //求f(20)
        if(N==0 || N==1){
            return N;
        }
        int pre = 0;
        int cur = 1;
        for(int i =2; i<=N;i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

    public void runLinear(){
        int i = fibReverseLinear(4);
        System.out.println(i);
    }
    @Test
    public void test() {
        run();
        runMem();
        runLinear();
    }
}

