package leetcode.editor.cn;

import java.util.Arrays;

//179、最大数
class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        //int[] nums = {34323,3432};
        int[] nums = {34323, 3432};
        String s = solution.largestNumber(nums);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //TODO
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = new StringBuilder(String.valueOf(nums[i])).reverse().toString();
            }
            StringBuilder builder = new StringBuilder();
            Arrays.sort(strings);
            for (int i = 0; i < n; i++) {
                builder.append(strings[i]);
            }
            return builder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}