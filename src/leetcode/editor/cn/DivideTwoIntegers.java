package leetcode.editor.cn;

//29、两数相除
class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        int divide = solution.divide(100, 4);
        System.out.println(divide);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //Time Limit Exceeded
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (dividend == 0) {
                return 0;
            }

            boolean flag = false;
            int ans = 0;
            if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
                flag = true;
            }
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            while (dividend <= divisor) {
                dividend -= divisor;
                ans--;
            }
            if (flag) {
                ans = -ans;
            }
            return -ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}