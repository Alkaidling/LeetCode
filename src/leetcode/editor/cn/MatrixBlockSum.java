package leetcode.editor.cn;

import java.util.Arrays;

//1314、矩阵区域和
class MatrixBlockSum {
    public static void main(String[] args) {
        Solution solution = new MatrixBlockSum().new Solution();
        //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{67,64,78},{99,98,38},{82,46,46},{6,52,55},{55,99,45}};
        int[][] ints = solution.matrixBlockSum(mat, 3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // 前缀和
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] answer = new int[m][n];
            return answer;
        }

        //O(m*n*k²)
        //执行耗时:437 ms,击败了5.01% 的Java用户 内存消耗:39.6 MB,击败了29.65% 的Java用户
        public int[][] matrixBlockSum0(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] answer = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int r = i-k >= 0 ? i-k : 0;
                    for (; r <= i+k; r++) {
                        int c = j-k >= 0 ? j-k : 0;
                        for (; c <= j+k; c++) {
                            if(c < n && r < m){
                                answer[i][j] += mat[r][c];
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}