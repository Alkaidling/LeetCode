package leetcode.editor.cn;

import java.util.*;

//1342、将数字变成 0 的操作次数
class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        Solution solution = new NumberOfStepsToReduceANumberToZero().new Solution();
        System.out.println(solution.numberOfSteps(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSteps(int num) {
            int res = 0;
            while (num != 0) {
                if (num % 2 == 0) {
                    num /= 2;
                }else {
                    num--;
                }
                res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}