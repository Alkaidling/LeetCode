package leetcode.editor.cn;

//518、零钱兑换 II
class CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        int change = solution.change(5, new int[]{1,2,5});
        System.out.println(change);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount+1];  //dp[i]为总金额为i时的方法数
            dp[0] = 1;
            for (int coin : coins) {  //两层循环不能交换顺序
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i-coin];
                }
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}