package leetcode.editor.cn;

import java.util.*;

//219、存在重复元素 II
class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashSet<Integer> set = new HashSet<>();
            int i = k, j = 0;
            for (int l = 0; l < k && l < nums.length; l++) {
                if (set.contains(nums[l])) {
                    return true;
                }
                set.add(nums[l]);
            }
            while (i < nums.length) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i++]);
                set.remove(nums[j++]);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}