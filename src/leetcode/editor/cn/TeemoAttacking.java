package leetcode.editor.cn;

//495、提莫攻击
class TeemoAttacking {
    public static void main(String[] args) {
        Solution solution = new TeemoAttacking().new Solution();
        int[] nums = {1,2};
        int poisonedDuration = solution.findPoisonedDuration(nums, 2);
        System.out.println(poisonedDuration);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:2 ms,击败了90.57% 的Java用户 内存消耗:40.3 MB,击败了28.50% 的Java用户
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int n = timeSeries.length;
            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                res += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
            }
            return res + duration;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}