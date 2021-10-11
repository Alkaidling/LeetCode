package leetcode.editor.cn;


//198、打家劫舍
class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        int[] nums = {9, 1, 1, 9, 1, 1, 9, 1, 1, 9};
        int rob = solution.rob(nums);
        System.out.println(rob);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n) O(1)
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int prePre = nums[0];
            int pre = Math.max(nums[0],nums[1]);
            int ans = pre;
            for (int i = 2; i < n; i++) {
                ans = Math.max(prePre+nums[i],pre);
                prePre = pre;
                pre = ans;
            }
            return ans;
        }

        //O(n) O(n)
        public int rob1(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]); //状态转移方程
            }
            return dp[n-1];
        }

        //O(n²) O(n)
        public int rob0(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = nums[1];
            for (int i = 2; i < n; i++) {
                int maxVal = -1;
                for (int j = 0; j < i - 1; j++) {
                    if (dp[j] > maxVal) {
                        maxVal = dp[j];
                    }
                }
                dp[i] = maxVal + nums[i];
            }
            return Math.max(dp[n - 2], dp[n - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}