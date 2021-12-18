package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 012、左右两边子数组的和相等
class Tvdfij {
    public static void main(String[] args) {
        Solution solution = new Tvdfij().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum * 2 + nums[i] == total) {
                    return i;
                }
                sum += nums[i];
            }
            return -1;
        }


        public int pivotIndex1(int[] nums) {
            int n = nums.length;
            int sum = 0;
            int[] aftSum = new int[n];
            aftSum[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                aftSum[i] = aftSum[i + 1] + nums[i];
            }
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if(sum == aftSum[i]){
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}