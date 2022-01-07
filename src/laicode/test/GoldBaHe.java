package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/06 21:05
 */
public class GoldBaHe {

    public static void main(String[] args) {
        int limit = 10000;
        for(int i=4;i<limit;i++) {
            if (i % 2 == 0) {
                boolean res = check(i);
                if (res) {
                    System.out.println(i + " is true thinking");
                } else {
                    System.out.println("pride is awarded");
                    break;
                }
            }
        }
    }

    private static boolean check(int num) {
        for(int i=1;i<num;i++){
            if(isPrime(i) && isPrime(num-i)){
                return true;
            }
        }
        return false;
    }

    private static boolean isPrime(int i) {
        for(int n = 2; n<i;n++){
            if(i %n == 0){
                return false;
            }
        }
        return true;
    }
}
