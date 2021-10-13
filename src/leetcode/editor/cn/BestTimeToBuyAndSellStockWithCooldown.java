package leetcode.editor.cn;

//309、最佳买卖股票时机含冷冻期
class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        int[] prices = {1, 2, 3, 0, 2};
        int i = solution.maxProfit(prices);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            // f[i][0]: 手上持有股票的最大收益
            // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
            // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
            int[][] f = new int[n][3];
            f[0][0] = -prices[0];
            for (int i = 1; i < n; ++i) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);  //max(不持有，买入=前一天不持有-当天价钱)
                f[i][1] = f[i - 1][0] + prices[i];                         //前一天卖出
                f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);              //max(前一天还在冷冻期，前一天也不在冷冻期)
            }
            return Math.max(f[n - 1][1], f[n - 1][2]);
        }

        public int maxProfit0(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                //如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，
                //即dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即dp[i−1][1]，这时候我们要将其卖出，并获得prices[i] 的收益。
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                int pre0 = dp[i - 1][0];
                if (i > 1) {  //i>1时卖出股票会进入冷却期，所以应为两天前结束时还没有股票，即dp[i - 2][0]
                    pre0 = dp[i - 2][0];
                }
                //前一天已经持有一支股票，即dp[i−1][1]，
                //或者冷冻期结束时还没有股票，即pre0，这时候我们要将其买入，并减少prices[i] 的收益。
                dp[i][1] = Math.max(dp[i - 1][1], pre0 - prices[i]);
            }
            return dp[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}