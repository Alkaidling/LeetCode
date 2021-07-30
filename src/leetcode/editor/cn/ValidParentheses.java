package leetcode.editor.cn;

import java.util.Stack;

//Java：20有效的括号
class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //version1

    public boolean isValid(String s) {
        Stack stack = new Stack<>();
        Stack stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        /**
         * @Description:
         * 在两个栈中进行元素弹出弹入：
         * 将s中的元素先挨个压入stack1
         * 再将stack1中的元素与stack2中比较并压入s2。
         * 1、若为s1为左括号且s2为右括号则匹配成功，s1，s2均弹出元素，否则返回false
         * 2、若为右括号则将s1的元素压入s2
         * 3、s1为空结束循环
         * 最后s1、s2均为空则匹配成功返回true
         * @param s
         * @return: {@link boolean}
         * @Author: Alkaid
         * @Date: 2021/7/30 11:56
         **/
        while (!stack.empty()) {
            if (stack.peek().toString().equals("(")){
                if(stack2.empty() || stack2.peek().toString().equals("]") || stack2.peek().toString().equals("}")){
                    return false;
                }else if (stack2.peek().toString().equals(")")){
                    stack.pop();
                    stack2.pop();
                }
            }
            else if (stack.peek().toString().equals("[")){
                if(stack2.empty() || stack2.peek().toString().equals(")") || stack2.peek().toString().equals("}")){
                    return false;
                }else if (stack2.peek().toString().equals("]")){
                    stack.pop();
                    stack2.pop();
                }
            }
            else if (stack.peek().toString().equals("{")){
                if(stack2.empty() || stack2.peek().toString().equals(")") || stack2.peek().toString().equals("]")){
                    return false;
                }else if (stack2.peek().toString().equals("}")){
                    stack.pop();
                    stack2.pop();
                }
            }
            else
                stack2.push(stack.pop());

        }
        if (stack2.empty())
            return true;
        else
            return false;
    }

//version2
        /**
         * @Description:
         * 将左括号压入栈，如果后面的括号与之匹配，则将它出栈，
         * 继续下一轮匹配。如果是有效的字符串，也就是每对括号都完全匹配，栈最后会为空
         * 最后判断栈是否为空可以知道是否为有效字符串。
         * @param s
         * @return: {@link boolean}
         * @Author: Alkaid
         * @Date: 2021/7/30 12:00
         **/
    public boolean isValid2(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                stack.push(ch[i]);
            } else if (!stack.isEmpty()) {
                if (stack.peek() == '(' && ch[i] == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && ch[i] == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && ch[i] == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}