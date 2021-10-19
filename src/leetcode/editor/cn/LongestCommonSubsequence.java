package leetcode.editor.cn;

//1143、最长公共子序列
class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        int i = solution.longestCommonSubsequence("bl", "yby");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n*m) O(m) 滚动数组一行数组
        public int longestCommonSubsequence(String text1, String text2) {
            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            int n = chars1.length;
            int m = chars2.length;
            int[] dp = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                int pre = dp[0];
                int cur;
                for (int j = 1; j <= m; j++) {
                    cur = dp[j];
                    if (chars1[i - 1] == chars2[j - 1]) {
                        dp[j] = pre + 1;  //pre === dp[i - 1][j - 1] 前一行的前一个
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);  //等价于dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  max(前一行的当前位置，当前行的前一个)
                    }
                    pre = cur;
                }
            }
            return dp[m];
        }

        //O(n*m) O(n*m)
        //执行耗时:6 ms,击败了95.58% 的Java用户 内存消耗:42 MB,击败了61.54% 的Java用户
        public int longestCommonSubsequence1(String text1, String text2) {
            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            int n = chars1.length;
            int m = chars2.length;
            int[][] dp = new int[n + 1][m + 1];  //dp[i][j]表示的是 text1 [0,i-1] 和 text2[0,j-1]的最长公共子序列长度
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (chars1[i - 1] == chars2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
        }

        //O(n*m) O(n*m)
        //执行耗时:7 ms,击败了91.30% 的Java用户 内存消耗:42.4 MB,击败了5.21% 的Java用户
        public int longestCommonSubsequence0(String text1, String text2) {
            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            int n = chars1.length;
            int m = chars2.length;
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (chars1[i] == chars2[j]) {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        }
                    } else {
                        if (i == 0 && j == 0) {
                            dp[i][j] = 0;
                        } else if (i == 0) {
                            dp[i][j] = dp[i][j - 1];
                        } else if (j == 0) {
                            dp[i][j] = dp[i - 1][j];
                        } else {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }
                }
            }
            return dp[n - 1][m - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}