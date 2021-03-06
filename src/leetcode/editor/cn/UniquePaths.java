package leetcode.editor.cn;

//62、不同路径
class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        int i = solution.uniquePaths(3, 7);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //O(m*n)  O(n) 只用一行存储
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    }else {
                        dp[j] += dp[j-1];
                    }
                }
            }
            return dp[n-1];
        }
        //O(m*n)  O(m*n)
        public int uniquePaths1(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}