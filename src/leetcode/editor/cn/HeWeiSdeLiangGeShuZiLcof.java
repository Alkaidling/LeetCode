package leetcode.editor.cn;

//剑指 Offer 57、和为s的两个数字
class HeWeiSdeLiangGeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLiangGeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //双指针 O(n)
        public int[] twoSum(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                }else {
                    return new int[]{nums[i],nums[j]};
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}