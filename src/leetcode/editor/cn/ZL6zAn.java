package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 105、岛屿的最大面积
class ZL6zAn {
    public static void main(String[] args) {
        Solution solution = new ZL6zAn().new Solution();
        int[][] g = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(solution.maxAreaOfIsland(g));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        //BFS
        public int maxAreaOfIsland(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        int t = 0;
                        ArrayDeque<Integer> queueI = new ArrayDeque<>();
                        ArrayDeque<Integer> queueJ = new ArrayDeque<>();
                        queueI.offer(i);
                        queueJ.offer(j);
                        while (!queueI.isEmpty()) {
                            int curI = queueI.poll();
                            int curJ = queueJ.poll();
                            if (curI < 0 || curI >= grid.length || curJ < 0 || curJ >= grid[0].length || grid[curI][curJ] == 0) {
                                continue;
                            }
                            t++;
                            grid[curI][curJ] = 0;
                            for (int k = 0; k < 4; k++) {
                                queueI.offer(curI + x[k]);
                                queueJ.offer(curJ + y[k]);
                            }
                        }
                        res = Math.max(t,res);
                    }
                }
            }
            return res;
        }

        //DFS
        public int maxAreaOfIsland0(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;
            int sum = 1;
            for (int k = 0; k < 4; k++) {
                sum += dfs(grid,i + x[k], j + y[k]);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}