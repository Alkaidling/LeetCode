package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 040、矩阵中最大的矩形
class PLYXKQ {
    public static void main(String[] args) {
        Solution solution = new PLYXKQ().new Solution();
        solution.maximalRectangle(new String[]{"10100","10111","11111","10010"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(String[] matrix) {
            if (matrix.length == 0 || matrix[0].length() == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length();
            int[] h = new int[n];
            int res = 0;
            for (String s : matrix) {
                char[] row = s.toCharArray();
                for (int i = 0; i < row.length; i++) {
                    if (row[i] == '0') {
                        h[i] = 0;
                    }else {
                        h[i]++;
                    }
                }
                res = Math.max(res, largestRectangleArea(h));
            }
            return res;
        }
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right,n);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    right[stack.pop()] = i;
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res,(right[i] - left[i] - 1) * heights[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}