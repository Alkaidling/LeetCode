package leetcode.editor.cn;

//剑指 Offer 46、把数字翻译成字符串
class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        int i = solution.translateNum(12256);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String str = String.valueOf(num);
            char[] chars = str.toCharArray();
            int n = chars.length;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int x = chars[i] - '0';
                int pre = chars[i - 1] - '0';
                if (pre == 1 || (pre == 2 && x < 6)) {
                    if (i == 1) {
                        dp[i] = dp[i - 1] + 1;
                    }else {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}