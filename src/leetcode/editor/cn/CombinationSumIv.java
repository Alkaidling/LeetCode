package leetcode.editor.cn;

//377、组合总和 Ⅳ
class CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIv().new Solution();
        int i = solution.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target+1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if(i >= num){
                        dp[i] += dp[i-num];
                    }
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}