package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 096、字符串交织
class IY6buf {
    public static void main(String[] args) {
        Solution solution = new IY6buf().new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length();
            int n2 = s2.length();
            if (n1 + n2 != s3.length()) {
                return false;
            }
            boolean[][] dp = new boolean[n1 + 1][n2 + 1];
            dp[0][0] = true;
            for (int i = 0; i <= n1; i++) {
                for (int j = 0; j <= n2; j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        dp[i][j] = dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(p);
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                    }
                }
            }
            return dp[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}