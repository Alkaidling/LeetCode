package leetcode.editor.cn;

import java.util.Arrays;

//807、保持城市天际线
class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        Solution solution = new MaxIncreaseToKeepCitySkyline().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //贪心
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int n = grid.length;
            int[] rowMax = new int[n];
            int[] colMax = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rowMax[i] = Math.max(rowMax[i],grid[i][j]);
                    colMax[j] = Math.max(colMax[j],grid[i][j]);
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += Math.min(rowMax[i],colMax[j]) - grid[i][j];
                }
            }
            return res;
        }

        //O(n²)
        public int maxIncreaseKeepingSkyline0(int[][] grid) {
            int n = grid.length;
            int[][] gridNew = new int[n][n];
            for (int i = 0; i < n; i++) {
                int max = -1;
                for (int j = 0; j < n; j++) {
                    max = Math.max(grid[i][j],max);
                }
                Arrays.fill(gridNew [i],max);
            }
            for (int j = 0; j < n; j++) {
                int max = -1;
                for (int i = 0; i < n; i++) {
                    max = Math.max(grid[i][j],max);
                }
                for (int i = 0; i < n; i++) {
                    gridNew [i][j] = Math.min(max,gridNew [i][j]);
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += gridNew [i][j] - grid[i][j];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}