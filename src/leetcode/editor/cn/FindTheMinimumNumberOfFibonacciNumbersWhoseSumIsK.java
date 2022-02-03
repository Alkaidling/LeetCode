package leetcode.editor.cn;

import java.util.*;

//1414、和为 K 的最少斐波那契数字数目
class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().new Solution();
        System.out.println(solution.findMinFibonacciNumbers(19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinFibonacciNumbers(int k) {
            ArrayList<Integer> list = new ArrayList<>();
            int a = 1, b = 2, c = 0;
            list.add(a);
            list.add(b);
            while (c <= k) {
                c = a + b;
                list.add(c);
                a = b;
                b = c;
            }
            int res = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                while (k >= list.get(i)){
                    k -= list.get(i);
                    res++;
                }
                if (k == 0) {
                    return res;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}