package leetcode.editor.cn;

//剑指 Offer 63、股票的最大利润
class GuPiaoDeZuiDaLiRunLcof {
    public static void main(String[] args) {
        Solution solution = new GuPiaoDeZuiDaLiRunLcof().new Solution();
        int i = solution.maxProfit(new int[]{7});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int min = prices[0];
            int res = 0;
            for (int price : prices) {
                min = Math.min(price,min);
                res = Math.max(res,price - min);
            }
            return res;
        }


        public int maxProfit0(int[] prices) {
            int n = prices.length;
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n];
            int min = prices[0];  //min为历史最低值.
            //int max = 0;
            //for (int i = 1; i < n; i++) {
            //    dp[i] = Math.max(0,dp[i-1]+prices[i]-prices[i-1]); //如果累计收益为正 则进行计算否则 不卖出收益为0
            //    max = Math.max(max,dp[i]);
            //}
            //return max;
            for (int i = 1; i < n; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                dp[i] = Math.max(prices[i] - min, dp[i - 1]);
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}