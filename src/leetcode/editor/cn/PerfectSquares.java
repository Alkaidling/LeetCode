package leetcode.editor.cn;

//279、完全平方数
class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        int i = solution.numSquares(13);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:22 ms,击败了91.99% 的Java用户 内存消耗:37.5 MB,击败了57.61% 的Java用户
        public int numSquares0(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int minn = i;
                for (int j = 1; j * j <= i; j++) {//获取f[i-j*j]的最小值
                    minn = Math.min(minn, dp[i - j * j]);
                }
                dp[i] = minn + 1;
            }
            return dp[n];
        }

        //O(n^(3/2))
        //执行耗时:45 ms,击败了45.87% 的Java用户 内存消耗:37.5 MB,击败了64.20% 的Java用户
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}