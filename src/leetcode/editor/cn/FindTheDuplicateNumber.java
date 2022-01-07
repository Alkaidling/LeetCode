package leetcode.editor.cn;

import java.util.*;

//287、寻找重复数
class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        solution.findDuplicate(new int[]{3,1,3,4,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分
        public int findDuplicate(int[] nums) {
            int left = 1, right = nums.length - 1, res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int cnt = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                    res = mid;
                }
            }
            return res;
        }

        //修改原数组
        public int findDuplicate0(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                while (nums[i] != i) {
                    int t = nums[i];
                    nums[i] = nums[t];
                    nums[t] = t;
                    if(nums[i] == nums[t]){
                        return nums[t];
                    }
                }
            }
            return nums[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}