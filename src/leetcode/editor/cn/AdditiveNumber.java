package leetcode.editor.cn;

import java.util.*;

//306、累加数
class AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber().new Solution();
        System.out.println(solution.isAdditiveNumber("112358"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int secondStart = 1; secondStart < n - 1; secondStart++) {
                if (num.charAt(0) == '0' && secondStart != 1) {
                    break;
                }
                for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                    if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                        break;
                    }
                    if (valid(0,secondStart - 1,secondStart, secondEnd, num)) {
                        return true;
                    }
                }
            }
            return false;
        }
        private boolean valid(int firstStart, int firstEnd,int secondStart, int secondEnd, String num) {
            long first = Long.parseLong(num.substring(firstStart,firstEnd + 1));
            long second = Long.parseLong(num.substring(secondStart,secondEnd + 1));
            StringBuilder sb = new StringBuilder();
            sb.append(first);
            sb.append(second);
            while (sb.length() < num.length()) {
                long third = first + second;
                sb.append(third);
                first = second;
                second = third;
            }
            return num.equals(sb.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}