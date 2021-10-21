package leetcode.editor.cn;

//343、整数拆分
class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        int i = solution.integerBreak(6);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //贪心
        public int integerBreak(int n) {
            if (n < 4) {
                return n - 1;
            }
            int a = n / 3;
            int b = n % 3;
            if (b == 0) {
                return (int) Math.pow(3, a);
            } else if (b == 1) {
                return (int) (Math.pow(3, a - 1) * 4);
            } else {
                return (int) (Math.pow(3, a) * 2);
            }
        }

        //O(n²) O(n)
        public int integerBreak0(int n) {
            if (n < 4) {
                return n - 1;
            }
            int[] dp = new int[n + 1];
            //dp[i] = Math.max(dp[i-1],dp[i-2]*2,...,dp[1]*(i-1));
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                for (int j = i - 1; j > 0; j--) {
                    dp[i] = Math.max(dp[i], dp[j] * (i - j));
                }
            }
            //for (int i = 3; i <= n; i++) {
            //    dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
            //}
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}