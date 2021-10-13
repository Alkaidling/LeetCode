package leetcode.editor.cn;

//714、买卖股票的最佳时机含手续费
class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        int[] prices = {1,3,2,8,4,9};
        //int[] prices = {1, 3, 7, 5, 10, 3};
        int i = solution.maxProfit(prices, 2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;            //无股票
            dp[0][1] = -prices[0];   //有股票
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);  //max(前一天无股票，当天卖出=前一天有股票+当天价钱-手续费)
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);        //max(前一天有股票，当天买入=前一天无股票-当天价钱)
            }
            return dp[n - 1][0];
        }

        //贪心
        public int maxProfit0(int[] prices, int fee) {
            int n = prices.length;
            int buy = prices[0] + fee;
            int profit = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] + fee < buy) {
                    buy = prices[i] + fee;          //第i天买入花费更少
                } else if (prices[i] > buy) {       //第i天卖出大于手续费
                    profit += prices[i] - buy;
                    //buy跟新为第i天的价钱，即当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
                    // (反悔操作)假如下一天天卖出赚的更多，也不影响最后结果，下次循环 profit += prices[i] - buy(buy即为prices[i-1])
                    buy = prices[i];
                }
            }
            return profit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}