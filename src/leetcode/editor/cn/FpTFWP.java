package leetcode.editor.cn;

import java.util.Arrays;

//剑指 Offer II 112、最长递增路径
class FpTFWP {
    public static void main(String[] args) {
        Solution solution = new FpTFWP().new Solution();
        System.out.println(solution.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        for (int i = 0; i < solution.memo.length; i++) {
            System.out.println(Arrays.toString(solution.memo[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m, n;
        int[][] matrix, memo;

        public int longestIncreasingPath(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            this.matrix = matrix;
            memo = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, dfs(i, j));
                }
            }
            return res;
        }

        private int dfs(int i, int j) {
            if (memo[i][j] != 0) {
                return memo[i][j];
            }
            memo[i][j] = 1;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                    memo[i][j] = Math.max(memo[i][j], dfs(x, y) + 1);
                }
            }
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}