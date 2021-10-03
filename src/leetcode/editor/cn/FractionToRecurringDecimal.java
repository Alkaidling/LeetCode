package leetcode.editor.cn;

import java.math.BigDecimal;

//166、分数到小数
class FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        int a = 1;
        int b = 502;
        String s = solution.fractionToDecimal(a, b);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //BigDecimal
        public String fractionToDecimal(int numerator, int denominator) {
            BigDecimal a = new BigDecimal(numerator);
            BigDecimal b = new BigDecimal(denominator);
            BigDecimal res = a.divide(b, 320, BigDecimal.ROUND_DOWN);
            //double res = (double)numerator / (double)denominator;
            StringBuilder builder = new StringBuilder();
            builder.append(res);
            if (builder.length() < 4 || builder.charAt(1) != '.') {
                return builder.toString();
            }
            int left = 0;
            int right = 1;
            builder = builder.reverse();
            while (builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            }
            while (builder.charAt(right + 1) != '.') {
                if (builder.charAt(left) == builder.charAt(right) && builder.charAt(left + 1) == builder.charAt(right + 1)) {
                    left++;
                    right++;
                } else {
                    right++;
                }
            }
            String s = builder.substring(left + 1, right + 1);
            StringBuilder str = new StringBuilder();
            str.append(s);
            str = str.reverse();
            int length = s.length();
            int length1 = builder.length();
            if (s.length() != builder.length() - 3) {
                builder = new StringBuilder();
                builder.append("0.(");
                builder.append(str);
                builder.append(")");
                return builder.toString();
            } else {
                return builder.reverse().toString();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}