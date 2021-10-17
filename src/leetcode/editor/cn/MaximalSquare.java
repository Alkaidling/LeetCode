package leetcode.editor.cn;

//221、最大正方形
class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        //char[][] matrix = {{'1', '1', '1', '0', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'0','1'},{'1','0'}};
        //char[][] matrix = {{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}};
        int i = solution.maximalSquare(matrix);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // dp[i][j]表示以i，j为左下角的矩形的面积 , 改为边长存储更方便比较
        public int maximalSquare(char[][] matrix) {
            return 0;
        }


        //写的什么几把玩意儿
        //执行耗时:5 ms,击败了92.76% 的Java用户 内存消耗:41.4 MB,击败了79.46% 的Java用户
        public int maximalSquare0(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n]; //dp[i][j]表示以i，j为左下角的矩形的面积 , 改为边长存储更方便比较
            int max = 0;
            for (int i = 0; i < m; i++) {
                dp[i][0] = matrix[i][0] - '0';
                max = Math.max(max, dp[i][0]);
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = matrix[0][i] - '0';
                max = Math.max(max, dp[0][i]);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] - '0' == 0) {
                        dp[i][j] = 0;
                    } else {
                        int num = dp[i - 1][j - 1];
                        int temp = 0;
                        for (int k = 1; k * k <= num; k++) {
                            int colNum = matrix[i - k][j] - '0';
                            int rowNum = matrix[i][j - k] - '0';
                            if (colNum == 0 || rowNum == 0) {
                                if (dp[i][j] == 0) {
                                    dp[i][j] = matrix[i][j] - '0';
                                    break;
                                } else {
                                    temp = ((dp[i][j] / 2) + 1) * ((dp[i][j] / 2) + 1);
                                    dp[i][j] = temp;
                                    break;
                                }
                            }
                            dp[i][j] += colNum + rowNum;
                        }
                        if (dp[i][j] != matrix[i][j] - '0' && temp == 0) {
                            dp[i][j] += num + 1;
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}