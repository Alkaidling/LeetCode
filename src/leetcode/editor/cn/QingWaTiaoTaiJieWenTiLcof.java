package leetcode.editor.cn;


//Java：剑指 Offer 10- II、青蛙跳台阶问题
class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        int i = solution.numWays(4);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final int MOD = 1000000007;
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int pre2 = 1;  //n-2阶
        int pre1 = 2;  //n-1阶
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = (pre2 + pre1) % MOD;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}