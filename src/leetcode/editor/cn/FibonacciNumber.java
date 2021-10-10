package leetcode.editor.cn;
//509、斐波那契数
class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        int pre = 1;  //f1 = 1
        int prePre = 0;  //f0 = 0
        int ans = pre + prePre;
        if (n < 2) {
            return n;
        }
        for (int i = 2; i < n; i++) {
            prePre = pre;
            pre = ans;
            ans = pre + prePre;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}