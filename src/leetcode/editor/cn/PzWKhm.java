package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 090、环形房屋偷盗
class PzWKhm {
    public static void main(String[] args) {
        Solution solution = new PzWKhm().new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int[] dp = new int[n + 1];
            int res;
            dp[2] = nums[1];
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
            res = dp[n];
            dp[1] = nums[0];
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
            res = Math.max(res, dp[n - 1]);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}