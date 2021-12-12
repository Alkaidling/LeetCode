package leetcode.editor.cn;

import java.util.Arrays;

//剑指 Offer 60、n个骰子的点数
class NgeTouZiDeDianShuLcof {
    public static void main(String[] args) {
        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
        double[] doubles = solution.dicesProbability(4);
        System.out.println(Arrays.toString(doubles));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            求n个骰子掷出值为x时的概率
            1、掷出一个骰子的值为k:1-6，概率均为1/6
            2、求掷出n-1个骰子的值为x-k的概率
            问题即为n-1个骰子值为 x-1的概率 * 1/6 + x-2的概率 * 1/6 + ... + x-6的概率 * 1/6
            dp[i][j]表示i个骰子掷出和为j时的概率（一共n个骰子，和最大为n*6）
            dp[i][j] = dp[i-1][j-1] * 1/6 + dp[i-1][j-2] * 1/6 + ... + dp[i-1][j-6] * 1/6;
         */
        public double[] dicesProbability(int n) {
            double[][] dp = new double[n + 1][n * 6 + 1];  //dp[i][j]表示 i 个骰子的和为 j 时的概率（一共n个骰子，和最大为n*6）
            for (int j = 1; j <= 6; j++) {
                dp[1][j] = 1.0 / 6.0;  //1个骰子的和为1-6，概率均为1/6
            }
            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= i * 6; j++) { //j表示i个骰子的和为 i 到 i*6
                    for (int k = 1; k <= 6; k++) { //由i-1个骰子的和计算，当第i个骰子值为k:1-6时，i-1个骰子和需要为j-k
                        if (j - k > 0) {
                            dp[i][j] += dp[i-1][j-k] / 6.0;
                        }else {
                            break;
                        }
                    }
                }
            }
            double[] res = new double[n * 5 + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = dp[n][n+i]; //n个骰子从和为n开始
            }
            return res;
        }

        public double[] dicesProbability0(int n) {
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0 / 6.0);
            for (int i = 2; i <= n; i++) {
                double[] t = new double[5 * i + 1];
                for (int j = 0; j < dp.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        t[j + k] += dp[j] / 6.0;
                    }
                }
                dp = t;
            }
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}