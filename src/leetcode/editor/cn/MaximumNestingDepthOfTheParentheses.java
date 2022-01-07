package leetcode.editor.cn;

import java.util.*;

//1614、括号的最大嵌套深度
class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        Solution solution = new MaximumNestingDepthOfTheParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDepth(String s) {
            int cnt = 0;
            int max = 0;
            for (char ch : s.toCharArray()) {
                if(ch == '('){
                    cnt++;
                    max = Math.max(max,cnt);
                }else if(ch == ')'){
                    cnt--;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}