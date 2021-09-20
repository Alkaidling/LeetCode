package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//Java：673、最长递增子序列的个数
class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
        int[] nums = {1,3,5,4,7};
        solution.findNumberOfLIS(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        ArrayList<Deque<Integer>> lists = new ArrayList<>();
        int n = 0;
        for (int j = 0; j < nums.length; j++) {
            Deque<Integer> dp = new ArrayDeque<>();
             for (int i = 0; i < nums.length; i++) {
                 if (dp.isEmpty() || nums[i] > dp.peek()) {
                     dp.push(nums[i]);
                 }
            }
            lists.add(dp);
        }

        System.out.println(lists);
        if (lists.size() != 0) {
            return n;
        }
        return nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}