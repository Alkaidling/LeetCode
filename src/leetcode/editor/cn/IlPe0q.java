package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 100、三角形中最小路径之和
class IlPe0q {
    public static void main(String[] args) {
        Solution solution = new IlPe0q().new Solution();
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(lists));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = triangle.get(n - 1).get(i);
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = Math.min(dp[j],dp[j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
        public int minimumTotal1(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];
            dp[0] = triangle.get(0).get(0);
            for (int i = 1; i < n; i++) {
                List<Integer> list = triangle.get(i);
                dp[i] = dp[i - 1] + list.get(i);
                for (int j = i - 1; j > 0; j--) {
                    dp[j] = Math.min(dp[j],dp[j - 1]) + list.get(j);
                }
                dp[0] += list.get(0);
            }
            int res = Integer.MAX_VALUE;
            for (int i : dp) {
                res = Math.min(i,res);
            }
            return res;
        }

        public int minimumTotal0(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; i++) {
                List<Integer> list = triangle.get(i);
                dp[i][0] = dp[i - 1][0] + list.get(0);
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j - 1]) + list.get(j);
                }
                dp[i][i] = dp[i - 1][i - 1] + list.get(i);
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.min(res,dp[n - 1][i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}