package leetcode.editor.cn;

import java.util.*;

//238、除自身以外数组的乘积
class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            int mul = 1;
            for (int i = 0; i < n; i++) {
                res[i] = mul;
                mul *= nums[i];
            }
            mul = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= mul;
                mul *= nums[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}