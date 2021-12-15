package leetcode.editor.cn;

//剑指 Offer II 001、整数除法
class Xoh6Oh {
    public static void main(String[] args) {
        Solution solution = new Xoh6Oh().new Solution();
        int divide = solution.divide(-2147483648, 2);
        System.out.println(divide);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            boolean flag = false;
            int ans = 0;
            if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
                flag = true;  //结果为负
            }
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            while (dividend <= divisor) {
                int val = divisor;
                int quo = 1;
                while (val >= (Integer.MIN_VALUE >> 1) && dividend <= val + val) {
                    val += val;
                    quo += quo;
                }
                dividend -= val;
                ans += quo;
            }
            if (flag) {
                ans = -ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}