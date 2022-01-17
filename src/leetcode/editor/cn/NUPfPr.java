package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 101、分割等和子集
class NUPfPr {
    public static void main(String[] args) {
        Solution solution = new NUPfPr().new Solution();
        System.out.println(solution.canPartition(new int[]{9,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0, n = nums.length, max = 0;
            if (n < 2) {
                return false;
            }
            for (int num : nums) {
                sum += num;
                max = Math.max(max,num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            sum /= 2;
            if (max > sum) {
                return false;
            }
            boolean[][] dp = new boolean[n][sum + 1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; i++) {
                int num = nums[i];
                for (int j = 0; j <= sum; j++) {
                    if (j >= num) {
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n - 1][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}