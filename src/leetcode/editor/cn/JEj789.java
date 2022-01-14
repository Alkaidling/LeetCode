package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 091、粉刷房子
class JEj789 {
    public static void main(String[] args) {
        Solution solution = new JEj789().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length;
            int[][] dp = new int[n + 1][3];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1],dp[i - 1][2]) + costs[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0],dp[i - 1][2]) + costs[i - 1][1];
                dp[i][2] = Math.min(dp[i - 1][0],dp[i - 1][1]) + costs[i - 1][2];
            }
            return Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}