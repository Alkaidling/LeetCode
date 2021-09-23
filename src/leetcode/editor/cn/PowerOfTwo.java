package leetcode.editor.cn;
//Java：231、2 的幂
class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
        //return n > 0 && (n & -n) == n;
    }

    public boolean isPowerOfTwo1(int n) {
        while (n % 2 == 0 & n > 0) {
            n /= 2;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}