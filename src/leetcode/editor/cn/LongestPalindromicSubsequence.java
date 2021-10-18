package leetcode.editor.cn;

//516、最长回文子序列
class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
        int bbbab = solution.longestPalindromeSubseq("dccabaccd");
        System.out.println(bbbab);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // dp
        public int longestPalindromeSubseq(String s) {
            return 0;
        }


        //中心扩散法
        // 70 / 86 个通过测试用例
        public int longestPalindromeSubseq1(String s) {
            if (s == null || s.length() < 1) {
                return 0;
            }
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);//字串规模从i=0 -> i=len-1 到 i=len-1 -> i=len-1
                int len2 = expandAroundCenter(s, i, i + 1);
                len = Math.max(len,Math.max(len1, len2));
            }
            return len;
        }

        //中心扩散
        public int expandAroundCenter(String s, int left, int right) {
            //只要相等就把上限+1，下限-1
            for(int start = left; start >= 0; start--){
                for(int end = right; end < s.length(); end++){
                    while (start >= 0 && end < s.length() && left >= 0 && right < s.length() && s.charAt(start) == s.charAt(end)){
                        --start;
                        ++end;
                        --left;
                        ++right;
                    }
                }
            }
            return right - left - 1;  //返回相等字符串的长度
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}