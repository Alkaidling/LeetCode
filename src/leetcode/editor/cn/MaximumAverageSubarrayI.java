package leetcode.editor.cn;

//643、子数组最大平均数 I
class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        int[] nums = {1,12,-5,-6,50,3};
        double maxAverage = solution.findMaxAverage(nums, 5);
        System.out.println(maxAverage);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int start = 0;
            int end = k - 1;
            int temp = 0;

            for (int i = start; i <= end; i++) {
                temp += nums[i];
            }

            int sum = temp;
            while (end < nums.length) {
                sum = Math.max(temp, sum);
                if (end == nums.length - 1) {
                    break;
                }
                temp -= nums[start++];
                temp += nums[++end];
            }

            return 1.0 * sum / k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}