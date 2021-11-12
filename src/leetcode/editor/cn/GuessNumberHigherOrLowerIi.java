package leetcode.editor.cn;

//375、猜数字大小 II
class GuessNumberHigherOrLowerIi {
    public static void main(String[] args) {
        Solution solution = new GuessNumberHigherOrLowerIi().new Solution();
        int moneyAmount = solution.getMoneyAmount(10);
        System.out.println(moneyAmount);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //区间型dp f(1,n)=x+max(f(1,x−1),f(x+1,n))。
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n + 2][n + 2];  //dp[i][j]表示i和j中猜中所需最少的钱
            for (int len = 2; len <= n; len++) {
                for (int i = 1; i + len - 1 <= n; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        //猜k且猜错，若小于k则再i到k-1中猜，否则在k+1到j中猜，取最差情况
                        int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                        dp[i][j] = Math.min(dp[i][j], cost); //所有的k中取最小值，即当以k往左右两边分时所需代价最小
                    }
                }
            }
            return dp[1][n];
        }


        //二分DFS ❌
        public int getMoneyAmount0(int n) {
            int[][] dp = new int[n + 1][n + 1];
            int res = Integer.MAX_VALUE;
            for (int i = 11; i < n + 1; i++) {
                int max = 0;
                for (int j = 14; j < n + 1; j++) {
                    dp[i][j] = dfs(1, n, i, j, 0);
                    max = Math.max(dp[i][j], max);
                }
                res = Math.min(res, max);
            }
            return res;
        }

        private int dfs(int start, int end, int root, int target, int res) {
            if (root == target) {
                return res;
            } else if (root > target) {
                return dfs(start, root - 1, (start + root - 1) / 2, target, res + root);
            } else {
                return dfs(root + 1, end, (root + 1 + end) / 2, target, res + root);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}