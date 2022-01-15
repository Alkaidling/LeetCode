package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 095、最长公共子序列
class QJnOS7 {
    public static void main(String[] args) {
        Solution solution = new QJnOS7().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();
            int[][] dp = new int[n1 + 1][n2 + 1];  //dp[i][j] 为 t1 : 0-i, t2 : 0-j 的公共子序列
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                    }
                }
            }
            return dp[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}