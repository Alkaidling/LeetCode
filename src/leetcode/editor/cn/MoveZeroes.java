package leetcode.editor.cn;

import java.util.*;

//283、移动零
class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{0,1,0,3,12});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //覆盖
        public void moveZeroes(int[] nums) {
            int idx = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[idx++] = num;
                }
            }
            while (idx < nums.length) {
                nums[idx++] = 0;
            }
        }
        //双指针
        public void moveZeroes1(int[] nums) {
            int n = nums.length;
            int left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    int t = nums[left];
                    nums[left] = nums[right];
                    nums[right] = t;
                    left++;
                }
                right++;
            }
        }

        //冒泡 O(n²)
        public void moveZeroes0(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                boolean swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (nums[j] == 0) {
                        nums[j] = nums[j + 1];
                        nums[j + 1] = 0;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}