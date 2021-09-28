package leetcode.editor.cn;

import java.util.Arrays;

//59、螺旋矩阵 II
class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] ints = solution.generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int maxRow = n - 1; //最大行
        int minRow = 0;  //最小行
        int maxCol = n - 1; //最大列
        int minCol = 0; //最小列
        int i = 0; //当前行
        int j = 0; //当前列

        int num = 1;
        res[i][j] = num++;
        while (num <= n * n) {
            while (j < maxCol) {
                j++;
                res[i][j] = num++;
            }
            minRow++;

            while (i < maxRow){
                i++;
                res[i][j] = num++;
            }
            maxCol--;

            while (j > minCol) {
                j--;
                res[i][j] = num++;
            }
            maxRow--;

            while (i > minRow) {
                i--;
                res[i][j] = num++;
            }
            minCol++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}