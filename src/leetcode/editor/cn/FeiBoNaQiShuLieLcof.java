package leetcode.editor.cn;
//Java：剑指 Offer 10- I、斐波那契数列
class FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        long start = System.currentTimeMillis();
        int fib = solution.fib(100000000);
        long end = System.currentTimeMillis();
        System.out.println(fib);
        System.out.println(end - start);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static final int MOD = 1000000007;

    public int fib(int n) {
        if(n < 2)
            return n;

        int pre = 0;
        int next = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {  //时间复杂度 O(n)
            result = (pre + next) % MOD;
            pre = next;
            next = result;
        }

        return result;

        //return (fib(n-1) + fib(n - 2)) % 1000000007;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //矩阵快速幂
    //class Solution {
    //    static final int MOD = 1000000007;
    //
    //    public int fib(int n) {
    //        if (n < 2) {
    //            return n;
    //        }
    //        int[][] q = {{1, 1}, {1, 0}};
    //        int[][] res = pow(q, n - 1);
    //        return res[0][0];
    //    }
    //
    //    public int[][] pow(int[][] a, int n) {
    //        int[][] ret = {{1, 0}, {0, 1}};
    //        while (n > 0) {
    //            if ((n & 1) == 1) {
    //                ret = multiply(ret, a);
    //            }
    //            n >>= 1;  //时间复杂度 O(logn)
    //            a = multiply(a, a);
    //        }
    //        return ret;
    //    }
    //
    //    public int[][] multiply(int[][] a, int[][] b) {
    //        int[][] c = new int[2][2];
    //        for (int i = 0; i < 2; i++) {
    //            for (int j = 0; j < 2; j++) {
    //                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
    //            }
    //        }
    //        return c;
    //    }
    //
    //}
}