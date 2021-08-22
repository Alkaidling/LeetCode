package leetcode.editor.cn;
//Java：122、买卖股票的最佳时机 II
class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int result = 0;
        int[] dp = new int[len];
        //求出后一天减前一天的差，存入数组dp，即隔一天卖出的利润
        for (int i = 1; i < len; i++) {
            dp[i-1] = prices[i] - prices[i-1];
        }
        for (int i = 0; i < len; i++) {
            if(dp[i] > 0)
                result += dp[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}