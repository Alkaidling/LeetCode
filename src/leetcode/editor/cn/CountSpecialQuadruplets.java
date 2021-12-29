package leetcode.editor.cn;

import java.util.*;

//1995、统计特殊四元组
class CountSpecialQuadruplets {
    public static void main(String[] args) {
        Solution solution = new CountSpecialQuadruplets().new Solution();
        System.out.println(solution.countQuadruplets(new int[]{8, 73, 11, 9, 28, 92, 52}));
        System.out.println(solution.countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countQuadruplets(int[] nums) {
            int res = 0, n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int b = n - 3; b > 0; b--) {
                for (int d = b + 2; d < n; d++) {
                    map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
                }
                for (int a = 0; a < b; a++) {
                    res += map.getOrDefault(nums[a] + nums[b], 0);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}