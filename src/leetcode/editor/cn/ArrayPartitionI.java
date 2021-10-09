package leetcode.editor.cn;

import java.util.Arrays;

//561、数组拆分 I
class ArrayPartitionI {
    public static void main(String[] args) {
        Solution solution = new ArrayPartitionI().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}