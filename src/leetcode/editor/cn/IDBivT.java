package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 085、生成匹配的括号
class IDBivT {
    public static void main(String[] args) {
        Solution solution = new IDBivT().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> list = new ArrayList<>();
            dfs(n,n,"",list);
            return list;
        }

        private void dfs(int left, int right, String str, ArrayList<String> list) {
            if (left == 0 && right == 0) {
                list.add(str);
                return;
            }
            if (left > 0) {
                dfs(left - 1,right,str + "(",list);
            }
            if (right > left) {
                dfs(left,right - 1,str + ")",list);
            }
            //if (left == right) {
            //    dfs(left - 1,right,str + "(",list);
            //}else{
            //    if (left > 0) {
            //        dfs(left - 1,right,str + "(",list);
            //    }
            //    dfs(left,right - 1,str + ")",list);
            //}
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}