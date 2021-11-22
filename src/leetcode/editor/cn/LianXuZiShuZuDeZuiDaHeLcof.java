package leetcode.editor.cn;

//剑指 Offer 42、连续子数组的最大和
class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
                res = Math.max(res,dp[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}