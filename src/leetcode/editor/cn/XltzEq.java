package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 018、有效的回文
class XltzEq {
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
        System.out.println(solution.isPalindrome(",."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                    i++;
                }
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                    j--;
                }
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}