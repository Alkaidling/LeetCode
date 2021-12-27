package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 039、直方图最大矩形面积
class ZeroYnMMM {
    public static void main(String[] args) {
        Solution solution = new ZeroYnMMM().new Solution();
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

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

        public int largestRectangleArea0(int[] heights) {
            int n = heights.length;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            int res = 0;
            for (int i = 0; i < n; i++) {
                while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int width = i - stack.peek() - 1;
                    res = Math.max(res, height * width);
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                int height = heights[stack.pop()];
                int width = n - stack.peek() - 1;
                res = Math.max(res, height * width);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}