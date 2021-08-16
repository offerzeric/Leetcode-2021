package minFallDistance;

import org.junit.Test;

/**
 * 二维数组从第一行往下面落下，计算落到任意一点的最小值和
 *
 * @author ericzhang 2021/08/16 9:16 上午
 */
public class MinfallingDIstance {
    int mem[][] = new int[1000][1000];
    public int dp(int[][] matrix, int row, int column) {
        if (row == 0) return matrix[0][column];
        if(mem[row][column] != 0){
            return mem[row][column];
        }
        int leftUp = 66666;
        int rightUp = 66666;
        int straight = 66666;
        if (column > 0 && column <= 2 && row > 0 && row <= 2) {
            leftUp = dp(matrix, row - 1, column - 1) + matrix[row][column];
        }
        if (column >= 0 && column <= 2 && row > 0 && row <= 2) {
            straight = dp(matrix, row - 1, column) + matrix[row][column];
        }
        if (column >= 0 && column < 2 && row > 0 && row <= 2) {
            rightUp = dp(matrix, row - 1, column + 1) + matrix[row][column];
        }
        mem[row][column] =  Math.min(leftUp, Math.min(rightUp, straight));
        return mem[row][column];
    }

    @Test
    public void test() {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        //从最下层往上走 起点可能是最下层的任意一点
        int j = 0;
        int res = 99999;
        for (j = 0; j < 3; j++) {
            res = Math.min(res, dp(matrix, row, j));
        }
        System.out.println(res);
    }

}
