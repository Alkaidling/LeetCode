package leetcode.editor.cn;

import java.util.*;

//507、完美数
class PerfectNumber {
    public static void main(String[] args) {
        Solution solution = new PerfectNumber().new Solution();
        System.out.println(solution.checkPerfectNumber(28));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPerfectNumber(int num) {
            int res = 1;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    res += i;
                    if (i * i < num) {
                        res += num / i;
                    }
                }
            }
            return res == num && num != 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}