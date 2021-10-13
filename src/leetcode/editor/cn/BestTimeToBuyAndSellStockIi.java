package leetcode.editor.cn;

//Java：122、买卖股票的最佳时机 II
class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int max = 0, cur = 0, pre = 0;
            for (int i = 1; i < n; i++) {
                cur = Math.max(pre, pre + prices[i] - prices[i - 1]);
                pre = cur;
                max = Math.max(pre, max);
            }
            return max;
        }

        //贪心
        public int maxProfit0(int[] prices) {
            int n = prices.length;
            int max = 0;
            for (int i = 1; i < n; i++) {
                int profit = prices[i] - prices[i - 1];
                if (profit > 0) {
                    max += profit;
                }
            }
            return max;
        }


        //public int maxProfit(int[] prices) {
        //    int len = prices.length;
        //    int result = 0;
        //    int[] dp = new int[len];
        //    //求出后一天减前一天的差，存入数组dp，即隔一天卖出的利润
        //    for (int i = 1; i < len; i++) {
        //        dp[i - 1] = prices[i] - prices[i - 1];
        //    }
        //    for (int i = 0; i < len; i++) {
        //        if (dp[i] > 0)
        //            result += dp[i];
        //    }
        //    return result;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}