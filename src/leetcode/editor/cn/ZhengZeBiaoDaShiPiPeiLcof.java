package leetcode.editor.cn;

//剑指 Offer 19、正则表达式匹配
class ZhengZeBiaoDaShiPiPeiLcof {
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        System.out.println(solution.isMatch("ab", ".*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            char[] ss = s.toCharArray();
            char[] pp = p.toCharArray();
            int n = ss.length, m = pp.length;
            boolean[][] dp = new boolean[n + 1][m + 1];
            /*
                dp[i][j]  s前i个 和 p前j个匹配结果
                ss[i] == pp[j] || pp[j] == .
                      dp[i][j] = dp[i-1][j-1]
                pp[j] == *
                      if(ss[i] != pp[j-1])  //*此时代表0个字符
                          dp[i][j] = dp[i][j-2]
                      if(ss[i] == pp[j-1] || pp[j-1] == .)
                          dp[i][j] = dp[i][j-2] || dp[i-1][j]  //dp[i-1][j]指去掉ss[i]位置字符继续用p中 字符* 进行匹配
             */
            dp[0][0] = true;
            for (int j = 2; j < m; j++) {  //pp中若有两个字符是 字母* 则可跳过这两个字符再与ss从头匹配
                if(pp[j - 1] == '*'){
                    dp[0][j] = dp[0][j-2];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pp[j - 1] == '*') {
                        if (ss[i - 1] == pp[j - 2] || pp[j - 2] == '.') {
                            dp[i][j] = dp[i][j - 2] | dp[i - 1][j];
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