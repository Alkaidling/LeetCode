package leetcode.editor.cn;

import java.util.*;

//2022、将一维数组转变成二维数组
class Convert1dArrayInto2dArray {
    public static void main(String[] args) {
        Solution solution = new Convert1dArrayInto2dArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] construct2DArray(int[] original, int m, int n) {
            int[][] res = new int[m][n];
            int size = original.length;
            if (size != m * n) {
                return new int[0][];
            }
            int idx = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = original[idx++];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}