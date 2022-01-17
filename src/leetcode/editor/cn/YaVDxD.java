package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 102、加减的目标值
class YaVDxD {
    public static void main(String[] args) {
        Solution solution = new YaVDxD().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int dif = sum - target;
            if (dif < 0 || dif % 2 != 0) {
                return 0;
            }
            int neg = dif / 2;
            int[] dp = new int[neg + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = neg; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }
            return dp[neg];
        }

        public int findTargetSumWays0(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int dif = sum - target;
            if (dif < 0 || dif % 2 != 0) {
                return 0;
            }
            int n = nums.length, neg = dif / 2;
            int[][] dp = new int[n + 1][neg + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int num = nums[i - 1];
                for (int j = 0; j <= neg; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= num) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
            return dp[n][neg];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}