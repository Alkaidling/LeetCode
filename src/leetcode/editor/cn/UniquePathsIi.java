package leetcode.editor.cn;

//63、不同路径 II
class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length, m = obstacleGrid[0].length;
            int[] f = new int[m];
            f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (obstacleGrid[i][j] == 1) {
                        f[j] = 0;
                        continue;
                    }
                    if (j > 0 && obstacleGrid[i][j - 1] == 0) {
                        f[j] += f[j - 1];
                    }
                }
            }
            return f[m - 1];
        }

        //O(m*n) O(m*n) 能优化为一行dp数组
        public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            //首列初始化
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 0) {
                    dp[i][0] = 1;
                } else {
                    break;
                }
            }
            //首行初始化
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] == 0) {
                    dp[0][i] = 1;
                } else {
                    break;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}