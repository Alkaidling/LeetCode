package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 013、二维子矩阵的和
class O4NDxx {
    public static void main(String[] args) {
        //NumMatrix numMatrix = new O4NDxx().new NumMatrix();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        int[][] preSum;  //preSum[i][j] : 指matrix前i行前j列元素和

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            preSum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                int rowSum = 0;  //第i行的和
                for (int j = 1; j <= n; j++) {
                    //preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                    rowSum += matrix[i - 1][j - 1];
                    preSum[i][j] = preSum[i - 1][j] + rowSum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}