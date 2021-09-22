package leetcode.editor.cn;

//Java：剑指 Offer 14- II、剪绳子 II
class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = 1000000007;

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n-1;
        }

        long ans = 1L;

        while (n >= 5) {
            n -= 3;
            ans = ans * 3 % MOD;
        }
        ans = ans * n;
        return (int) (ans%MOD);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}