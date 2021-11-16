package leetcode.editor.cn;

//10、正则表达式匹配
class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        boolean match = solution.isMatch("aa", ".*");
        System.out.println(match);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp[i][j]  s前i个 和 p前j个匹配结果
        //i == 0
        //      if(pp[j-1] == '*'
        //          dp[i][j] = dp[i][j-2];
        //ss[i-1] == pp[j-1] || pp[j-1] == .
        //      dp[i][j] = dp[i-1][j-1]
        //pp[j-1] == *
        //      if(ss[i-1] != pp[j-2])
        //          dp[i][j] = dp[i][j-2]
        //      if(ss[i-1] == pp[j-2] || pp[j-2] == '.')
        //          dp[i][j] = dp[i][j-2] || dp[i-1][j](指的是a*匹配完ss对应的i位置字符，继续使用a*)
        public boolean isMatch(String s, String p) {
            char[] ss = s.toCharArray();
            char[] pp = p.toCharArray();
            int n = ss.length;
            int m = pp.length;
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[0][0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i == 0) {
                        if(pp[j - 1] == '*'){
                            dp[i][j] = dp[i][j-2];
                        }
                        continue;
                    }
                    if (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pp[j - 1] == '*') {
                        if (ss[i - 1] == pp[j - 2] || pp[j - 2] == '.') {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}