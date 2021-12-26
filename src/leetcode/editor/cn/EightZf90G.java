package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 036、后缀表达式
class EightZf90G {
    public static void main(String[] args) {
        Solution solution = new EightZf90G().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (String s : tokens) {
                if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                    stack.push(Integer.valueOf(s));
                }else {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int num3;
                    switch (s) {
                        case "+":
                            num3 = num1 + num2;
                            break;
                        case "-":
                            num3 = num2 - num1;
                            break;
                        case "*":
                            num3 = num2 * num1;
                            break;
                        default:
                            num3 = num2 / num1;
                            break;
                    }
                    stack.push(num3);
                }
            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}