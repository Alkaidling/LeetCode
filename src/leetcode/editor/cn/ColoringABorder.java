package leetcode.editor.cn;

import java.util.ArrayDeque;

//1034、边界着色
class ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new ColoringABorder().new Solution();
        int[][] gird = {{1,1,1},{1,1,1},{1,1,1}};
        solution.colorBorder(gird,1,1,2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            int m = grid.length, n = grid[0].length;
            boolean[][] visit = new boolean[m][n];
            int rootCol = grid[row][col];
            queue.offer(new int[]{row,col});
            visit[row][col] = true;
            int[] x = {1,0,-1,0};
            int[] y = {0,1,0,-1};
            while (!queue.isEmpty()) {
                int[] ints = queue.poll();
                int intsX = ints[0];
                int intsY = ints[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = x[i] + intsX;
                    int nextY = y[i] + intsY;
                    if (nextX < m && nextX >= 0 && nextY < n && nextY >= 0 && grid[nextX][nextY] == rootCol && !visit[nextX][nextY] ) {
                        queue.offer(new int[]{nextX,nextY});
                        visit[nextX][nextY] = true;
                    }
                }
                grid[intsX][intsY] = color;
            }
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if(visit[i][j] && visit[i-1][j] && visit[i+1][j] && visit[i][j-1] && visit[i][j+1]){
                        grid[i][j] = rootCol;
                    }
                }
            }
            return grid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}