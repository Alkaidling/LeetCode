package leetcode.editor.cn;

//Java：剑指 Offer 14- II、剪绳子 II
class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // n = n1 + n2 + ... + na
        // res = n1 * n2 * .. * na  求max(res)
        // (n1 + n2 + ... na) / a >= a√n1 * n2 * ... na
        //当n1 == n2 == ... == na时，等号成立,即res取得最大值

        //n = a*x  长度为x相等的a段
        //res = x^a
        //x^a == x^(n/x) == (x^(1/x))^n , n > 2
        //即求 x^(1/x)的最大值
        //x = e ≈ 2.7 取得最大值

        public static final int MOD = 1000000007;

        public int cuttingRope(int n) {
            if (n < 4) {
                return n - 1;
            }
            long res = 1;
            while (n >= 5) {
                n -= 3;
                res = res * 3 % MOD;
            }
            return (int) (res * n % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}