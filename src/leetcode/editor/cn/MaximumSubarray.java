package leetcode.editor.cn;

//Java：53、最大子序和
class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {-1, 2, -1, 2};
        System.out.println(solution.maxSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划 O(n) O(1)
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int pre = nums[0];
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                pre = Math.max(pre+nums[i],nums[i]);
                max = Math.max(max,pre);
            }
            return max;
        }

        //动态规划 O(n) O(n) 如果前边累加后还不如自己本身大，那就把前边的都扔掉，从此自己本身重新开始累加。
        public int maxSubArray1(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < n; i++) {
                if (dp[i-1] < 0){
                    dp[i] = nums[i];
                }else {
                    dp[i] = dp[i-1] + nums[i];
                }
                //dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
                if (dp[i] > res) {
                    res = dp[i];
                }
                //res = Math.max(res,dp[i]);
            }
            return res;
        }

        //暴力o(n)=n^2
        //public int maxSubArray1(int[] nums) {
        //    int result = nums[0], temp = 0;
        //    for (int i = 0; i < nums.length; i++) {
        //        temp = 0;
        //        for (int j = i; j < nums.length; j++) {
        //            temp += nums[j];
        //            if (temp > result)
        //                result = temp;
        //        }
        //    }
        //    return result;
        //}

        //动态规划
        //public int maxSubArray(int[] nums) {
        //    int n = nums.length;
        //    int[] dp = new int[n];
        //    dp[0] = nums[0];
        //    int max = nums[0];
        //    for (int i = 1; i < n; i++) {
        //        dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
        //        max = Math.max(max, dp[i]);
        //    }
        //    return max;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}