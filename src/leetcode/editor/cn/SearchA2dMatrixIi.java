package leetcode.editor.cn;

//240、搜索二维矩阵 II
class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        //int[][] matrix = {{-1,3}};
        boolean b = solution.searchMatrix(matrix, 30);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //从右上角搜索
        //执行耗时:5 ms,击败了96.31% 的Java用户 内存消耗:43.8 MB,击败了75.28% 的Java用户
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int row = 0;
            int col = n - 1;
            while (row < m && col >= 0) {
                if (matrix[row][col] > target) {
                    col--;
                }else if(matrix[row][col] < target){
                    row++;
                }else {
                    return true;
                }
            }
            return false;
        }


        //二分
        //执行耗时:13 ms,击败了11.86% 的Java用户 内存消耗:43.3 MB,击败了97.84% 的Java用户
        public boolean searchMatrix1(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            return binarySearch(matrix, target, 0, m-1, 0, n-1);
        }

        public boolean binarySearch(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
            if (rowStart <= rowEnd && colStart <= colEnd) {
                int rowMid = rowStart + (rowEnd - rowStart) / 2;
                int colMid = colStart + (colEnd - colStart) / 2;
                if (rowStart == rowEnd && colStart == colEnd) {
                    return matrix[rowStart][colStart] == target;
                }
                if (matrix[rowMid][colMid] > target) {
                    return binarySearch(matrix, target, rowStart, rowMid, colStart, colMid)
                            || binarySearch(matrix, target, rowMid + 1, rowEnd, colStart, colMid-1)
                            || binarySearch(matrix, target, rowStart, rowMid-1, colMid + 1, colEnd);
                } else if (matrix[rowMid][colMid] < target) {
                    return binarySearch(matrix, target, rowStart, rowMid, colMid + 1, colEnd)
                            || binarySearch(matrix, target, rowMid + 1, rowEnd, colStart, colMid)
                            || binarySearch(matrix, target, rowMid + 1, rowEnd, colMid + 1, colEnd);
                } else {
                    return true;
                }
            }else{
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}