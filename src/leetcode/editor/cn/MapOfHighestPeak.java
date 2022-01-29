package leetcode.editor.cn;

import java.util.*;

//1765、地图中的最高点
class MapOfHighestPeak {
    public static void main(String[] args) {
        Solution solution = new MapOfHighestPeak().new Solution();
        int[][] is = {{1}};
        int[][] ints = solution.highestPeak(is);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] highestPeak(int[][] isWater) {
            int m = isWater.length, n = isWater[0].length;
            int[][] res = new int[m][n];
            boolean[][] visit = new boolean[m][n];
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(isWater[i][j] == 0){
                        res[i][j] = 1;
                    }else {
                        queue.offer(new int[]{i,j});
                        visit[i][j] = true;
                    }
                }
            }
            int[] x = {1,0,-1,0};
            int[] y = {0,-1,0,1};
            while (!queue.isEmpty()) {
                int[] ints = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int i = ints[0] + x[k];
                    int j = ints[1] + y[k];
                    if (i >= 0 && i < m && j >= 0 && j < n && !visit[i][j]) {
                        res[i][j] = res[ints[0]][ints[1]] + 1;
                        queue.offer(new int[]{i,j});
                        visit[i][j] = true;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}