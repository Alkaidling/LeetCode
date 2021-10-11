package leetcode.editor.cn;

//213、打家劫舍 II
class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        //int[] nums = {7, 1, 1, 9, 1, 1, 9, 1, 1, 9};
        int[] nums = {1,2,3,4,5,6,1};
        int rob = solution.rob(nums);
        System.out.println(rob);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            } else if (n == 2) {
                return Math.max(nums[0],nums[1]);
            }

            int first = nums[0];
            int second = Math.max(nums[0],nums[1]);
            int ans = second;
            //不选择最后一间
            for (int i = 2; i < n-1; i++) {
                ans = Math.max(first+nums[i],second); //状态转移方程
                first = second;
                second = ans;
            }
            //选择最后一间（不选第一间）
            first = nums[1];
            second = Math.max(nums[1],nums[2]);
            int res = second;
            for (int i = 3; i < n; i++) {
                res = Math.max(first+nums[i],second);
                first = second;
                second = res;
            }
            return Math.max(res,ans);
        }

        //O(n) O(n)
        public int rob0(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            } else if (n == 2) {
                return Math.max(nums[0],nums[1]);
            }
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            //不选择最后一间
            for (int i = 2; i < n-1; i++) {
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]); //状态转移方程
            }
            int res = dp[n-2];
            //选择最后一间（不选第一间）
            dp[1] = nums[1];
            dp[2] = Math.max(nums[1],nums[2]);
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
            return Math.max(res,dp[n-1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}