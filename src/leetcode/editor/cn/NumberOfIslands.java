package leetcode.editor.cn;

import java.util.*;

//200、岛屿数量
class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        //char[][] grid = {{'1', '1', '0', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid = {{'1'}, {'1'}};
        solution.numIslands(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //bfs
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        grid[i][j] = '0';
                        Queue<Integer> queue = new ArrayDeque<>();
                        queue.add(i * n + j);
                        while (!queue.isEmpty()) {
                            int p = queue.poll();
                            int x = p / n;
                            int y = p % n;
                            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                                queue.offer((x - 1) * n + y);
                                grid[x - 1][y] = '0';
                            }
                            if (x + 1 < m && grid[x + 1][y] == '1') {
                                queue.offer((x + 1) * n + y);
                                grid[x + 1][y] = '0';
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                                queue.offer(x * n + y - 1);
                                grid[x][y - 1] = '0';
                            }
                            if (y + 1 < n && grid[x][y + 1] == '1') {
                                queue.offer(x * n + y + 1);
                                grid[x][y + 1] = '0';
                            }
                        }
                    }
                }
            }
            return res;
        }

        //dfs
        public int numIslands0(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(grid, i, j)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
                return false;
            }
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}