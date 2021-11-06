package leetcode.editor.cn;

import java.util.Arrays;

//268、丢失的数字
class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n)
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum = (n * (n + 1)) / 2;
            for (int i = 0; i < n; i++) {
                sum -= nums[i];
            }
            return sum;
        }

        //O(nlogn)
        public int missingNumber0(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}