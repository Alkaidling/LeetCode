package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 097、子序列的数目
class Two1dk04 {
    public static void main(String[] args) {
        Solution solution = new Two1dk04().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] dp = new int[m + 1][n + 1];
            if (m < n) {
                return 0;
            }
            dp[0][0] = 1;
            for (int i = 1; i <= m; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[m][n];
        }
        public int numDistinct0(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] dp = new int[m + 1][n + 1];
            if (m < n) {
                return 0;
            }
            for (int i = 0; i <= m; i++) {
                dp[i][n] = 1;
            }
            for (int i = m - 1; i >= 0; i--) {
                char sCh = s.charAt(i);
                for (int j = n - 1; j >= 0; j--) {
                    char tCh = t.charAt(j);
                    if (sCh == tCh) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    }else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}