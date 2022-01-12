package leetcode.editor.cn;

//300、最长递增子序列
class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] nums = {7,8,9,1,2,3,4,5};
        //int[] nums = {10,2,5,3,7,101,18};
        //int[] nums = {0,1,0,3,2,3};
        int i = solution.lengthOfLIS(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // 二分+贪心 O(nlogn)
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int max = 1;

            return max;
        }

        //O(n²)  dp 转移方程： dp[i] = max(dp[i], dp[j] + 1)  for j in [0, i)。
        public int lengthOfLIS0(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int max = 1;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]){
                        dp[i] = Math.max(dp[j]+1,dp[i]);
                    }
                }
                max = Math.max(dp[i],max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}