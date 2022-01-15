package leetcode.editor.cn;

import java.util.*;

//1716、计算力扣银行的钱
class CalculateMoneyInLeetcodeBank {
    public static void main(String[] args) {
        Solution solution = new CalculateMoneyInLeetcodeBank().new Solution();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalMoney(int n) {
            int res = n < 7 ? 0 : 28;
            int cnt  = n / 7;
            int carry = n % 7;
            int pre = 28;
            for (int i = 1; i < cnt; i++) {
                res += pre + 7;
                pre += 7;
            }
            for (int i = 1; i <= carry; i++) {
                res += cnt + i;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}