package leetcode.editor.cn;

import java.util.*;

//1725、可以形成最大正方形的矩形数目
class NumberOfRectanglesThatCanFormTheLargestSquare {
    public static void main(String[] args) {
        Solution solution = new NumberOfRectanglesThatCanFormTheLargestSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            int max = 0;
            int res = 0;
            for (int[] ints : rectangles) {
                max = Math.max(max, Math.min(ints[0], ints[1]));
            }
            for (int[] ints : rectangles) {
                int t = Math.min(ints[0], ints[1]);
                if (t == max) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}