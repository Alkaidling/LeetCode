package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 099、最小路径之和
class ZeroI0mDW {
    public static void main(String[] args) {
        Solution solution = new ZeroI0mDW().new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] dp = new int[n];
            dp[0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1] + grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                dp[0] += grid[i][0];
                for (int j = 1; j < n; j++) {
                    dp[j] = grid[i][j] + Math.min(dp[j],dp[j - 1]);
                }
            }
            return dp[n - 1];
        }
        public int minPathSum0(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}