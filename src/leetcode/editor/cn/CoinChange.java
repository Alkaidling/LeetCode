package leetcode.editor.cn;

import java.util.Arrays;

//322、零钱兑换
class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int i = solution.coinChange(new int[]{1}, 0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n*amount)
        //执行耗时:12 ms,击败了87.81% 的Java用户 内存消耗:37.7 MB,击败了83.28% 的Java用户
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            int max = amount + 1;
            Arrays.fill(dp,max);
            dp[0] = 0;  //0元 0个
            for (int i = 0; i <= amount; i++) {
                for (int j = 0; j < n; j++) {
                    if(i >= coins[j]){
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }

        //O(n*amount)
        //执行耗时:18 ms,击败了25.73% 的Java用户  内存消耗:37.9 MB,击败了35.30% 的Java用户
        public int coinChange0(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int n = coins.length;
            int[] dp = new int[amount + 1];
            for (int i = 0; i <= amount; i++) {
                dp[i] = dp[i] == 0 ? -1 : dp[i];
                if (i < n && coins[i] <= amount) {
                    dp[coins[i]] = 1;
                }
            }
            //coins[i] 结果为min dp[i-coins[i]]
            for (int i = 0; i <= amount; i++) {
                for (int j = 0; j < n; j++) {
                    if (i >= coins[j] && dp[i - coins[j]] != -1) {
                        if (dp[i] == -1) {
                            dp[i] = Integer.MAX_VALUE;
                        }
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}