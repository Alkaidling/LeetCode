package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 092、翻转字符
class CyJERH {
    public static void main(String[] args) {
        Solution solution = new CyJERH().new Solution();
        System.out.println(solution.minFlipsMonoIncr("00110"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int res = 0, cnt = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    cnt++;
                } else {
                    res = Math.min(res + 1, cnt);  //结果为 = 当前的0变为1，或者是之前的1变为0
                }
            }
            return res;
        }

        public int minFlipsMonoIncr1(String s) {
            int n = s.length();
            int[][] dp = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '1') {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                } else {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                }
            }
            return Math.min(dp[n][0], dp[n][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}