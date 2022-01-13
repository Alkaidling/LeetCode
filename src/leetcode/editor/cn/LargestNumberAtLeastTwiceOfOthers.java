package leetcode.editor.cn;

import java.util.*;

//747、至少是其他数字两倍的最大数
class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
        System.out.println(solution.dominantIndex(new int[]{0,0,3,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dominantIndex(int[] nums) {
            int max = -1, nextMax = -1;
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    nextMax = max;
                    max = nums[i];
                    idx = i;
                }else if (nums[i] > nextMax) {
                    nextMax = nums[i];
                }
            }
            return max  >= 2 *nextMax ? idx : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}