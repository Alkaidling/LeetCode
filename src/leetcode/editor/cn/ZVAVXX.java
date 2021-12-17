package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 009、乘积小于 K 的子数组
class ZVAVXX {
    public static void main(String[] args) {
        Solution solution = new ZVAVXX().new Solution();
        int[] n ={1,1,1};
        System.out.println(solution.numSubarrayProductLessThanK(n, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k < 2) {
                return 0;
            }
            int n = nums.length;
            int res = 0, left = 0, mul = 1;
            for (int i = 0; i < n; i++) {
                mul *= nums[i];
                while (mul >= k) {
                    mul /= nums[left++];
                }
                res += i - left + 1; //区间为[left,...,i] ... [i-1,i], [i];
            }
            return res;
        }


        public int numSubarrayProductLessThanK0(int[] nums, int k) {
            if (k < 2) {
                return 0;
            }
            int n = nums.length;
            int res = 0, left = 0, mul = 1;
            for (int i = 0; i < n; i++) {
                mul *= nums[i];
                while (mul >= k && left <= i) {
                    res += n - i;
                    mul /= nums[left];
                    left++;
                }
            }
            return (n + 1) * n / 2 - res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}