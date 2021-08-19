package queens;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * n*n的盘子  放入n个皇后  皇后为q  其余为.
 * N皇后问题   每行都可以放  3*3的方格   皇后可以在  该列 行  左上 左下  右上  右下中进行砍杀
 * 放置皇后保证每个之间不能攻击到
 * 一行只能放一个皇后
 *
 * @author ericzhang 2021/08/18 10:16 上午
 */
public class Queens {

    LinkedList<char[][]> res = new LinkedList<>();
    //该行开始的回溯排列+验证
    public void queensGamble(int row, char[][] array) {
        if (row == array.length) {
            char[][] arrayRes = new char[array.length][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int i1 = 0; i1 < array[i].length; i1++) {
                    arrayRes[i][i1] = array[i][i1];
                }
            }
            res.add(arrayRes);
            return;
        }
        int colLength = array[0].length;
        for (int col = 0; col < colLength; col++) {
            if (check(array, row, col)) {
                array[row][col] = 'Q';
                queensGamble(row + 1, array);
                array[row][col] = '|';
            }
        }
    }

    private boolean check(char[][] array, int row, int col) {
        //因为是往下面一个个摆放  所以摆放当前的时候不需要考虑下面的限制部分
        //同一列
        for (int i = 0, j = col; i < array.length; i++) {
            if (array[i][j] == 'Q') {
                return false;
            }
        }
        //左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 'Q') {
                return false;
            }
        }
        //右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < array[0].length; i--, j++) {
            if (array[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] array = new char[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                array[i][i1] = '|';
            }
        }
        queensGamble(0, array);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.deepToString(res.get(i)));
        }
    }


}
