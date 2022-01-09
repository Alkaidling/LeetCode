package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 076、数组中的第 k 大的数字
class Xx4gT2 {
    public static void main(String[] args) {
        Solution solution = new Xx4gT2().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, k - 1, 0, nums.length - 1);
        }

        public int quickSelect(int[] nums, int k, int left, int right) {
            if (left >= right) {
                return nums[left];
            }
            int i = left - 1, j = right + 1;
            int x = nums[left + (right - left) / 2];
            while (i < j) {
                do {
                    i++;
                } while (nums[i] > x);
                do {
                    j--;
                } while (nums[j] < x);
                if (i < j) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            if (j < k) {
                return quickSelect(nums, k, j + 1, right);
            }else {
                return quickSelect(nums, k, left, j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}