package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//73、矩阵置零
class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //单个变量存储信息 时间O(mn) 空间O(1)
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            boolean flagCol0 = false, flagRow0 = false;
            for (int i = 0; i < row; i++) {
                if(matrix[i][0] == 0){
                    flagCol0 = true;
                }
            }
            for (int i = 0; i < col; i++) {
                if(matrix[0][i] == 0){
                    flagRow0 = true;
                }
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (flagCol0) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (flagRow0) {
                for (int i = 0; i < col; i++) {
                    matrix[0][i] = 0;
                }
            }
        }


        //哈希表 (一维数组)  时间O(mn) 空间O(m+n)
        public void setZeroes2(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            HashSet<Integer> rowZero = new HashSet<>();
            HashSet<Integer> colZero = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {  //matrix中找0的位置
                        rowZero.add(i);
                        colZero.add(j);
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                if(rowZero.contains(i)){
                    for (int j = 0; j < col; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < col; i++) {
                if(colZero.contains(i)){
                    for (int j = 0; j < row; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }


        //二维数组   时间O(mn) 空间O(mn)
        public void setZeroes1(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] temp = new int[row][col];  //保存 matrix 数组的0位位置信息

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {  //matrix中找0的位置
                        temp[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (temp[i][j] == 1) {
                        for (int k = 0; k < col; k++) { //matrix中i行全为0
                            matrix[i][k] = 0;
                        }
                        for (int k = 0; k < row; k++) { //matrix中j列全为0
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}