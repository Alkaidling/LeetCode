package leetcode.editor.cn;

import java.util.*;

//1020、飞地的数量
class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] row = {1,0,-1,0};
        int[] col = {0,1,0,-1};
        boolean flag = false;
        public int numEnclaves(int[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        flag = false;
                        int t = dfs(grid,i,j);
                        if (!flag) {
                            res += t;
                        }
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
                    flag = true;
                }
                grid[i][j] = 0;
                int t = 1;
                for (int k = 0; k < 4; k++) {
                    int x = i + row[k], y = j + col[k];
                    t += dfs(grid,x,y);
                }
                return t;
            }else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}