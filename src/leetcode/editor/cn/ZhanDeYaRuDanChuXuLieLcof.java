package leetcode.editor.cn;

import java.util.ArrayDeque;

//剑指 Offer 31、栈的压入、弹出序列
class ZhanDeYaRuDanChuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int n = popped.length;
            int index = 0;
            for (int i = 0; i < n; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[index]){
                    index++;
                    stack.pop();
                }
            }
            return stack.isEmpty();

            //while (!stack.isEmpty()) {
            //    if(stack.peek() == popped[index++]){
            //        stack.pop();
            //    }else {
            //        return false;
            //    }
            //}
            //return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}