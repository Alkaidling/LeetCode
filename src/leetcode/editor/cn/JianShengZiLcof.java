package leetcode.editor.cn;

//Java：剑指 Offer 14- I、剪绳子
class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        int i = solution.cuttingRope(5);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //贪心算法
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            //int ans = 1;
            //int count = n / 3;
            //if(n - count*3 == 1){
            //    count--;
            //}
            //
            //while (n >= 5) {
            //    n -= 3;
            //    ans *= 3;
            //}
            //ans *= n;
            //return ans;

            int a = n / 3, b = n % 3;
            if (b == 0) {
                return (int) Math.pow(3, a);
            }
            if (b == 1) {
                return (int) Math.pow(3, a - 1) * 4;
            }
            return (int) Math.pow(3, a) * 2;
        }


        //动态规划
        public int cuttingRope0(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = i;
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}