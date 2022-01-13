package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 088、爬楼梯的最少成本
class GzCJIP {
    public static void main(String[] args) {
        Solution solution = new GzCJIP().new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < n; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
            return Math.min(dp[n - 1], dp[n - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}