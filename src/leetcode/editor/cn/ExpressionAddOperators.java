package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//282、给表达式添加运算符
class ExpressionAddOperators {
    public static void main(String[] args) {
        Solution solution = new ExpressionAddOperators().new Solution();
        List<String> strings = solution.addOperators("00", 0);
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        public List<String> addOperators(String num, int target) {
            int n = num.length();
            char[] chars = num.toCharArray();
            ArrayList<String> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            builder.append(chars[0]);
            dfs(chars, n, 1, chars[0]-'0',target, list,builder);
            return list;
        }

        //回溯
        private void dfs(char[] chars, int n, int index,int sum, int target, ArrayList<String> list,StringBuilder builder) {
            if (sum == target) {
                if (builder.length() == 2 * n - 1 && !list.contains(builder.toString())) {
                    list.add(builder.toString());
                }
            } else if (sum < target) {
                for (int i = index; i < n; i++) {
                    char ch = chars[i];
                    int preSum = sum;
                    builder.append('*');
                    builder.append(ch);
                    sum *= ch-'0';
                    dfs(chars,n,i+1,sum,target,list,builder);
                    int j = index;
                    while (n - j > 0) {
                        builder.deleteCharAt(builder.length()-1);
                        builder.deleteCharAt(builder.length()-1);
                        j++;
                    }
                    builder.append('+');
                    builder.append(ch);
                    sum = preSum;
                    sum += ch-'0';
                    dfs(chars,n,i+1,sum,target,list,builder);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}