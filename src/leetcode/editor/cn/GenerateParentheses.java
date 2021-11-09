package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//22、括号生成
class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            dfs(n, n, list, builder);
            return list;
        }

        private void dfs(int left, int right, ArrayList<String> list, StringBuilder builder) {
            if (left == 0 && right == 0) {
                list.add(builder.toString());
                return;
            }
            if (left == right) {
                //剩余左右括号数相等，下一个只能用左括号
                dfs(left-1,right,list,builder.append('('));
                builder.deleteCharAt(builder.length()-1);  //回溯
            } else if (left < right) {
                //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
                if (left > 0) {
                    dfs(left-1,right,list,builder.append('('));
                    builder.deleteCharAt(builder.length()-1);
                }
                dfs(left,right-1,list,builder.append(')'));
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}