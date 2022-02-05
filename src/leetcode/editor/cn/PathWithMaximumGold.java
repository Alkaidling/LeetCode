package leetcode.editor.cn;

import java.util.*;

//1219、黄金矿工
class PathWithMaximumGold {
    public static void main(String[] args) {
        Solution solution = new PathWithMaximumGold().new Solution();
        System.out.println(solution.getMaximumGold(new int[][]{{1,0,7,0,0,0}, {1,0,7,0,0,0}, {3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] row = {1, 0, -1, 0};
        int[] col = {0, 1, 0, -1};

        public int getMaximumGold(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        res = Math.max(dfs(grid, i, j), res);
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            int t = 0;
            int v = grid[i][j];
            grid[i][j] = 0;
            for (int k = 0; k < 4; k++) {
                int x = i + row[k], y = j + col[k];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
                    continue;
                }
                t = Math.max(dfs(grid, x, y), t);
            }
            grid[i][j] = v;
            return t + grid[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}