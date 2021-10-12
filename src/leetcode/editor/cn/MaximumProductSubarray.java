package leetcode.editor.cn;

//152、乘积最大子数组
class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        //int[] nums = {-2, -1, -2, 3, 2, -4, -1};
        //int[] nums = {-1,-3,6,-4,7,-1,2,5,-8,0,-2,1,-3,4,6,-7,5,-1,2};
        //int[] nums = {-1,-3,6,-4,7,-1,2,5,-8};
        int[] nums = {1,0,-1,2,3,-5,-2};
        int i = solution.maxProduct(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值min

        public int maxProduct(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int max = dp[0];
            int temp = dp[0];  //保存dp[i-1] * nums[i]的值
            for (int i = 1; i < n; i++) {
                if (dp[i - 1] * nums[i] > 0) {
                    dp[i] = dp[i - 1] * nums[i];
                } else if (dp[i - 1] * nums[i] <= 0) {
                    if (nums[i] * temp > 0) {
                        dp[i - 1] = temp;
                        dp[i] = temp * nums[i];
                    } else {
                        dp[i] = nums[i];
                    }
                }
                temp = dp[i - 1] * nums[i];
                max = dp[i] > max ? dp[i] : max;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}