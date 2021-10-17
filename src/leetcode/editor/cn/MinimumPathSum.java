package leetcode.editor.cn;

//64、最小路径和
class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        int i = solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //O(m*n) O(n)
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] dp = new int[n];
            dp[0] = grid[0][0];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    } else {
                        if (j == 0) {
                            dp[j] += grid[i][j];
                        } else {
                            dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                        }
                    }
                }
            }
            return dp[n - 1];
        }

        //O(m*n) O(m*n)
        public int minPathSum1(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = grid[0][i] + dp[0][i - 1];
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}