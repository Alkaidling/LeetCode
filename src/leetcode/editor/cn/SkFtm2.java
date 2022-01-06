package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 070、排序数组中只出现一次的数字
class SkFtm2 {
    public static void main(String[] args) {
        Solution solution = new SkFtm2().new Solution();
        int i = solution.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mid % 2 != 0) {
                    mid--;
                }
                if(nums[mid] == nums[mid + 1]){
                    left = mid + 2;
                }else {
                    right = mid;
                }
            }
            return nums[left];
        }

        public int singleNonDuplicate0(int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] == nums[mid - 1]) {
                    if ((right - mid) % 2 == 0) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] == nums[mid + 1]) {
                    if ((mid - left) % 2 == 0) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    return nums[mid];
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}