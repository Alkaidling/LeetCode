package leetcode.editor.cn;

//746、使用最小花费爬楼梯
class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
        int[] cost = {1, 100};
        int i = solution.minCostClimbingStairs(cost);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minCostClimbingStairs1(int[] cost) {
            int n = cost.length;
            int prev = 0, curr = 0;
            for (int i = 2; i <= n; i++) {
                int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
                prev = curr;
                curr = next;
            }
            return curr;
        }

        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n + 1]; //f[n] = min(f(n-1)+cost[n-1],f(n-2)+cost[n-2])
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}