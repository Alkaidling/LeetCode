package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//120、三角形最小路径和
class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(5,6,7),Arrays.asList(4,1,8,3));
        //List<List<Integer>> triangle = Arrays.asList(Arrays.asList(-10));
        //List<List<Integer>> triangle = Arrays.asList(Arrays.asList(-1),Arrays.asList(3,2),Arrays.asList(1,-2,-1));
        int i = solution.minimumTotal(triangle);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n²)  O(n)
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];
            List<Integer> curRow = triangle.get(0);
            dp[0] = curRow.get(0);
            for (int i = 1; i < n; ++i) {
                curRow = triangle.get(i);
                dp[i] = dp[i - 1] + curRow.get(i);
                for (int j = i - 1; j >= 0; --j) {
                    if (j == 0) {
                        dp[j] = curRow.get(j) + dp[j];
                    }else {
                        dp[j] = curRow.get(j) + Math.min(dp[j],dp[j-1]);
                    }
                }
            }
            int min = dp[0];
            for (int i : dp) {
                min = Math.min(min,i);
            }
            return min;
        }

        //O(n²)  O(2n)
        public int minimumTotal1(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] pre = new int[n];
            int[] cur = new int[n];
            List<Integer> curRow = triangle.get(0);
            for (int i = 0; i < n; i++) {
                pre[i] = curRow.get(0);
                cur[i] = Integer.MAX_VALUE;
            }
            for (int i = 1; i < n; i++) {
                curRow = triangle.get(i);
                for (int j = 0; j <= i; j++) {
                    cur[j] = 0;
                    if (j == 0) {
                        cur[j] = curRow.get(j) + pre[j];
                    }else {
                        cur[j] = curRow.get(j) + Math.min(pre[j],pre[j-1]);
                    }
                }
                for (int j = 0; j < n; j++) {
                    pre[j] = cur[j];
                }
            }
            int min = pre[0];
            for (int i : pre) {
                min = Math.min(min,i);
            }
            return min;
        }


        //O(n²)  O(n²)
        public int minimumTotal0(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            List<Integer> curRow = triangle.get(0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        dp[i][j] = curRow.get(0);
                    }else {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
            }
            for (int i = 1; i < n; i++) {
                curRow = triangle.get(i);
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        dp[i][j] = curRow.get(j) + dp[i-1][j];
                    }else {
                        dp[i][j] = curRow.get(j) + Math.min(dp[i-1][j],dp[i-1][j-1]);
                    }

                }
            }
            int min = dp[n-1][0];
            for (int i : dp[n - 1]) {
                min = Math.min(min,i);
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}