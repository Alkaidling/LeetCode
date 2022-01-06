package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 068、查找插入位置
class N6YdxV {
    public static void main(String[] args) {
        Solution solution = new N6YdxV().new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0,right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }else {
                    left =mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}