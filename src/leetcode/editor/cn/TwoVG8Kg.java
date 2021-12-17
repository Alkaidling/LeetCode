package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 008、和大于等于 target 的最短子数组
class TwoVG8Kg {
    public static void main(String[] args) {
        Solution solution = new TwoVG8Kg().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int res = Integer.MAX_VALUE;
            int sum = 0;
            int left = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                while (sum >= target) {
                    res = Math.min(res,i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}