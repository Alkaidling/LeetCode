package leetcode.editor.cn;

import java.util.Arrays;

//剑指 Offer 29、顺时针打印矩阵
class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] ints = solution.spiralOrder(matrix);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }
            int maxRow = matrix.length - 1, minRow = 0;
            int maxCol = matrix[0].length - 1, minCol = 0;
            int row = 0, col = 0;
            int[] res = new int[(maxRow + 1) * (maxCol + 1)];
            int index = 0;
            while (minCol <= maxCol || minRow <= maxRow) {
                while (col <= maxCol) {  //最上面行
                    res[index++] = matrix[row][col++];
                }
                row++;
                col--;
                minRow++;
                if (minRow > maxRow) {
                    break;
                }
                while (row <= maxRow) {  //最右边列
                    res[index++] = matrix[row++][col];
                }
                col--;
                row--;
                maxCol--;
                if (minCol > maxCol) {
                    break;
                }
                while (col >= minCol) {  //最下面行
                    res[index++] = matrix[row][col--];
                }
                col++;
                row--;
                maxRow--;
                if (minRow > maxRow) {
                    break;
                }
                while (row >= minRow) {  //最左面列
                    res[index++] = matrix[row--][col];
                }
                row++;
                col++;
                minCol++;
                if (minCol > maxCol) {
                    break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}