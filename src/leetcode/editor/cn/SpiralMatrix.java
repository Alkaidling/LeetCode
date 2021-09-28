package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//54、螺旋矩阵
class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] matrix = {{1,2},{3,4},{5,6}};
        //int[][] matrix = {{1},{2},{3}};
        int[][] matrix = {{1,2,3}};
        List<Integer> integers = solution.spiralOrder(matrix);
        System.out.println(integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            ArrayList<Integer> res = new ArrayList<>();
            int i = 0; //当前行
            int j = 0; //当前列
            int maxRow = row - 1; //最大行
            int minRow = 0;  //最小行
            int maxCol = col - 1; //最大列
            int minCol = 0; //最小列
            res.add(matrix[0][0]);

            while (maxRow >= minRow && maxCol >= minCol) {
                while (j < maxCol) {
                    j++;
                    res.add(matrix[i][j]);
                }
                minRow++;
                if (maxRow < minRow || maxCol < minCol) {
                    continue;
                }
                while (i < maxRow){
                    i++;
                    res.add(matrix[i][j]);
                }
                maxCol--;
                if (maxRow < minRow || maxCol < minCol) {
                    continue;
                }
                while (j > minCol) {
                    j--;
                    res.add(matrix[i][j]);
                }
                maxRow--;
                if (maxRow < minRow || maxCol < minCol) {
                    continue;
                }
                while (i > minRow) {
                    i--;
                    res.add(matrix[i][j]);
                }
                minCol++;
                if (maxRow < minRow || maxCol < minCol) {
                    continue;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}