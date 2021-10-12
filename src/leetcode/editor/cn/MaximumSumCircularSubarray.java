package leetcode.editor.cn;

//918、环形子数组的最大和
class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();
        //int[] nums = {1, -2, 3, -2};
        //int[] nums = {5,-3,5};
        //int[] nums = {3,-2,2,-1};
        int[] nums = {0,1,-3,-1,-1};
        int i = solution.maxSubarraySumCircular(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //TODO
        // 最大子序列和位于中间位置 即为 53 题
        // 最大子序列和位于两边 即全部的和 减去 中间部分 ，中间部分为最小字串和
        //public int maxSubarraySumCircular(int[] nums) {
        //    int maxSum=nums[0],minSum=nums[0],pre1=0,pre2=0,arrSum=0;
        //    for (int num : nums) {
        //        arrSum+=num;
        //        pre1=Math.max(num,pre1+num);
        //        maxSum=Math.max(maxSum,pre1);
        //        pre2=Math.min(num,pre2+num);
        //        minSum=Math.min(minSum,pre2);
        //    }
        //    if (maxSum<0){
        //        return maxSum;
        //    }
        //    return Math.max(arrSum-minSum,maxSum);
        //}

        //O(n²)	Time Limit Exceeded
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                dp[i] = nums[i];  //分别以i为起始位置求最长字串
                int j = i + 1;
                while (i != j) {
                    if (j == n) {
                        j = 0;
                        dp[n - 1] = nums[n - 1];
                    }
                    int pre = j - 1;
                    if (j == 0) {
                        pre = n - 1;
                    }
                    dp[j] = Math.max(dp[pre] + nums[j], nums[j]);
                    max = Math.max(dp[j], max);
                    j++;
                    if (j == n) {
                        j = 0;
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}