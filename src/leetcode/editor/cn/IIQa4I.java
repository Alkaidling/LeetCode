package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 038、每日温度
class IIQa4I {
    public static void main(String[] args) {
        Solution solution = new IIQa4I().new Solution();
        int[] ints = solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] res = new int[n];
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int i = 1;
            while (!stack.isEmpty() && i < n) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
                i++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}