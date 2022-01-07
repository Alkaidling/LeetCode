package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 072、求平方根
class JJ0w9p {
    public static void main(String[] args) {
        Solution solution = new JJ0w9p().new Solution();
        System.out.println(solution.mySqrt(7));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        double left = 1, right = x;
        while (right - left > 1e-5) {
            double mid = left + (right - left) / 2.0;
            if (mid * mid < x) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return (int) right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}