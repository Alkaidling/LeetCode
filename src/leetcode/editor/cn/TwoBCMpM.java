package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 107、矩阵中的距离
class TwoBCMpM {
    public static void main(String[] args) {
        Solution solution = new TwoBCMpM().new Solution();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] matrix = solution.updateMatrix(mat);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        //BFS
        public int[][] updateMatrix0(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            int[][] res = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j});  //从0的位置bfs找到1的距离
                        visit[i][j] = true;
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] ints = queue.poll();
                int i = ints[0], j = ints[1];
                for (int k = 0; k < 4; k++) {
                    int curI = i + x[k];
                    int curJ = j + y[k];
                    if (curI >= 0 && curI < mat.length && curJ >= 0 && curJ < mat[0].length && !visit[curI][curJ]) {
                        res[curI][curJ] = res[i][j] + 1;
                        queue.offer(new int[]{curI, curJ});
                        visit[curI][curJ] = true;
                    }
                }
            }
            return res;
        }
        //DP
        public int[][] updateMatrix(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            int[][] res = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        res[i][j] = 0;
                    }else {
                        res[i][j] = Integer.MAX_VALUE / 2;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i - 1 >= 0) {
                        res[i][j] = Math.min(res[i][j],res[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        res[i][j] = Math.min(res[i][j],res[i][j - 1] + 1);
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i + 1 < n) {
                        res[i][j] = Math.min(res[i][j],res[i + 1][j] + 1);
                    }
                    if (j + 1 < m) {
                        res[i][j] = Math.min(res[i][j],res[i][j + 1] + 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}