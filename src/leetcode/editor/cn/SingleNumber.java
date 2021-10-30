package leetcode.editor.cn;

//136、只出现一次的数字
class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //异或
        public int singleNumber(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                res ^= nums[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}