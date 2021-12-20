package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 020、回文子字符串的个数
class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
        int aabbaa = solution.countSubstrings0("aabbaa");
        System.out.println(aabbaa);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //中心扩展
        public int countSubstrings(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                res += countSub(s,i,i);
                res += countSub(s,i,i + 1);
            }
            return res;
        }

        private int countSub(String s, int start, int end) {
            int count = 0;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            }
            return count;
        }
        //dp
        public int countSubstrings0(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int res = 0;
            boolean[][] dp = new boolean[n][n];  //dp[i][j]表示s[i,j]是否是回文串
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;  //长度为1的字符串
                res++;
            }
            for (int len = 2; len <= n; len++) {  //len为字串长度
                for (int i = 0; i < n; i++) {  //i为字串左边界
                    int j = len + i - 1;         //j为字串右边界
                    if (j >= n) {
                        break;
                    }
                    if(chars[i] == chars[j]){
                        if (j - i < 3) {
                            dp[i][j] = true;
                        }else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }else {
                        dp[i][j] = false;
                    }
                    if(dp[i][j]){
                        res++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}