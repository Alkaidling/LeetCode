package leetcode.editor.cn;
//Java：70、爬楼梯
class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        int i = solution.climbStairs(45);
        int j = solution.climbStairs1(45);

        System.out.println(i);
        System.out.println(j);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        //dp数组中dp[i]则为第i层的结果，此时默认dp[0]=0
        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs1(int n) {
        //f(n) = f(n-1) + f(n-2)
        //n-2层：x   n-1层：y   n层：result = x + y
        int x = 0,y = 0,result = 1;
        for (int i = 1; i <= n; i++) {
            x = y;
            y = result;
            result = x + y;
        }
        return result;
    }

    //强行递归！
    //int count = 0;
    //public int climbStairs(int n) {
    //    if(n == 0)
    //        count++;
    //    if(n >= 0){
    //        climbStairs(n-1);
    //        climbStairs(n-2);
    //    }
    //    return count;
    //}

    //public int climbStairs(int n) {
    //    if(n == 1)
    //        return 1;
    //    if(n == 2)
    //        return 2;
    //    return climbStairs(n-1) + climbStairs(n - 2);
    //}
}
//leetcode submit region end(Prohibit modification and deletion)

}