package leetcode.editor.cn;

//931、下降路径最小和
class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        //int[][] matrix = {{-19,57},{-40,-5}};
        int i = solution.minFallingPathSum(matrix);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n²)  O(1)
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0 && j < n - 1) {
                        matrix[i][j] += Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
                    } else if (j == 0) {
                        matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                    } else if (j == n - 1) {
                        matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                    }
                }
            }
            int min = matrix[n-1][0];
            for (int i = 0; i < n; i++) {
                min = min > matrix[n-1][i] ? matrix[n-1][i] : min;
            }
            return min;
        }


        //O(n²)  O(n²)
        public int minFallingPathSum0(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = matrix[0][i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0 && j < n - 1) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                    } else if (j == 0) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                    } else if (j == n - 1) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
                    }
                }
            }
            int min = dp[n-1][0];
            for (int i = 0; i < n; i++) {
                min = min > dp[n-1][i] ? dp[n-1][i] : min;
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}