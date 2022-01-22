package leetcode.editor.cn;

import java.util.*;

//1332、删除回文子序列
class RemovePalindromicSubsequences {
    public static void main(String[] args) {
        Solution solution = new RemovePalindromicSubsequences().new Solution();
        System.out.println(solution.removePalindromeSub("ababb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removePalindromeSub(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return 2;
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}