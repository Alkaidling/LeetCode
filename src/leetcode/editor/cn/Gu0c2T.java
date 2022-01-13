package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 089、房屋偷盗
class Gu0c2T {
    public static void main(String[] args) {
        Solution solution = new Gu0c2T().new Solution();
        System.out.println(solution.rob(new int[]{2,7,9,3,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            dp[1] = nums[0];
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i - 1]);
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}