package leetcode.editor.cn;

import java.util.Arrays;

//453、最小操作次数使数组元素相等
class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {
            int n = nums.length;
            int min = nums[0];
            int res = 0;
            for (int i = 0; i < n; i++) {
                min = nums[i] < min ? nums[i] : min;
            }
            //int min = Arrays.stream(nums).min().getAsInt();
            for (int i = 0; i < n; i++) {
                res += nums[i] - min;

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}