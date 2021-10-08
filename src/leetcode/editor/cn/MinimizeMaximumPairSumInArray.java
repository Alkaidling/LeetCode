package leetcode.editor.cn;

import java.util.Arrays;

//1877、数组中最大数对和的最小值
class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {
        Solution solution = new MinimizeMaximumPairSumInArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int j = n-1;
        for (int i = 0; i < j; i++) {
            ans = Math.max(nums[i]+nums[j--],ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}