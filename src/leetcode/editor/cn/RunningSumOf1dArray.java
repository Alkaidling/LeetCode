package leetcode.editor.cn;

import java.util.Arrays;

//Java：1480、一维数组的动态和
class RunningSumOf1dArray {
    public static void main(String[] args) {
        Solution solution = new RunningSumOf1dArray().new Solution();
        int[] nums = {3,1,2,10,1};
        int[] ints = solution.runningSum(nums);
        System.out.println(Arrays.toString(ints));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] runningSum(int[] nums) {
        //int len = nums.length;
        //for (int i = 1; i < len; i++) {
        //    nums[i] += nums[i-1];
        //}
        //return nums;

        int len = nums.length;
        int[] result = new int[len];
        int temp = 0;
        for (int i = 0; i < len; i++) {
            result[i] = nums[i] + temp;
            temp = result[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}