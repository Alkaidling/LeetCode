package leetcode.editor.cn;

import java.util.*;

//334、递增的三元子序列
class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution solution = new IncreasingTripletSubsequence().new Solution();
        System.out.println(solution.increasingTriplet(new int[]{20,100,10,12,5,13}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            int first = nums[0];
            int second = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < first) {
                    first = nums[i];
                } else if (nums[i] > first && nums[i] < second) {
                    second = nums[i];
                } else if (nums[i] > second) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}