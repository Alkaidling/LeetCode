package leetcode.editor.cn;

//Java：121、买卖股票的最佳时机
class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        //int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {7,6,4,3,1};
        //int[] prices = {7};
        int[] prices = {1, 4, 2};
        int i = solution.maxProfit(prices);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //dp   dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1])
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int max = 0;
            //int[] dp = new int[n];
            //dp[0] = 0;
            int pre = 0;
            int cur = 0;
            for (int i = 1; i < n; i++) {
                //dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1]); //如果当天利润加上之前的累计的利润小于0，则置为0
                cur = Math.max(0, pre + prices[i] - prices[i - 1]);
                pre = cur;
                //max = Math.max(max, dp[i]);
                max = Math.max(max, pre);
            }
            return max;
        }

        //O(n)
        public int maxProfit3(int[] prices) {
            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min)
                    min = prices[i];  //更新历史最低点
                else if (prices[i] - min > result)  //第i天卖出的利润
                    result = prices[i] - min;
            }
            return result;
        }

        //O(n)
        public int maxProfit1(int[] prices) {
            int[] dp = new int[prices.length];
            //求出后一天减前一天的差，存入数组dp，即隔一天卖出的利润
            for (int i = 1; i < prices.length; i++) {
                dp[i - 1] = prices[i] - prices[i - 1];
            }
            //求dp最大子序和，即利润最大
            int pre = dp[0];
            int result = pre;
            for (int i = 1; i < dp.length; i++) {
                pre = Math.max(pre + dp[i], dp[i]);
                result = Math.max(pre, result);
            }
            if (result < 0)
                return 0;
            return result;
        }

        //O(n²)
        public int maxProfit2(int[] prices) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (prices[i] - prices[j] > result)
                        result = prices[i] - prices[j];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}