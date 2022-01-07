package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 071、按权重生成随机数
class CuyjEf {
    public static void main(String[] args) {
        Solution solution = new CuyjEf().new Solution(new int[]{1, 2, 3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random;
        int sum;
        int[] pre;

        public Solution(int[] w) {
            for (int i : w) {
                sum += i;
            }
            random = new Random();
            pre = new int[w.length];
            pre[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                pre[i] = pre[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int target = (int) (Math.random() * sum) + 1;
            int left = 0, right = pre.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (pre[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}