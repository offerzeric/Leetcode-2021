package minFallDistance;

import org.junit.Test;

/**
 * 二维数组从第一行往下面落下，计算落到任意一点的最小值和
 *
 * @author ericzhang 2021/08/16 9:16 上午
 */
public class MinfallingDIstance {

    //    public int dp(int[][] matrix, int row, int column){
//        if(row == 0) return matrix[0][column];
//        int leftUp = 66666;
//        int rightUp = 66666;
//        int straight = 66666;
//        if(column > 0 && column <= 2 && row > 0 && row <= 2) {
//            leftUp = dp(matrix, row - 1, column - 1) + matrix[row][column];
//        }
//        if(column >= 0 && column <= 2 && row > 0 && row <= 2) {
//            straight = dp(matrix, row - 1, column) + matrix[row][column];
//        }
//        if(column >= 0 && column < 2 && row > 0 && row <= 2) {
//            rightUp = dp(matrix, row - 1, column + 1) + matrix[row][column];
//        }
//        return Math.min(leftUp,Math.min(rightUp,straight));
//    }
    public int dp(int[][] matrix, int row, int column) {
        if(row < 0 || row > 2 || column < 0 || column > 2) {
            return 99999;
        }
        if (row == 0) return matrix[0][column];
        int leftUp = dp(matrix, row - 1, column - 1) + matrix[row][column];
        int straight = dp(matrix, row - 1, column) + matrix[row][column];
        int rightUp = dp(matrix, row - 1, column + 1) + matrix[row][column];
        return Math.min(leftUp, Math.min(rightUp, straight));
    }

    @Test
    public void test() {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        System.out.println(dp(matrix, row, column));
    }

}
