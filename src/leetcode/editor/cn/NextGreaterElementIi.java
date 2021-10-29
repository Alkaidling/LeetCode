package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//503、下一个更大元素 II
class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        int[] ints = solution.nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //单调栈
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 2 * n - 2; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                    stack.pop();
                }

                if (!stack.isEmpty() && i < n) {
                    res[i] = stack.peek();
                } else if (stack.isEmpty() && i < n) {
                    res[i] = -1;
                }

                stack.push(nums[i % n]);
            }


            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}