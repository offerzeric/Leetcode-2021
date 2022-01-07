package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/06 16:03
 */
public class TestValuePass {
    public static void main(String[] args) {
        Simple s1 = new Simple("1");
        changeVal(s1);
        System.out.println(s1.getValue());

    }

    private static void changeVal(Simple s1) {
        Simple new1  = new Simple("2");
        s1 = new1;
    }

}
