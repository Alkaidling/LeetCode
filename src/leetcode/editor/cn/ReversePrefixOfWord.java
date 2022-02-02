package leetcode.editor.cn;

import java.util.*;

//2000、反转单词前缀
class ReversePrefixOfWord {
    public static void main(String[] args) {
        Solution solution = new ReversePrefixOfWord().new Solution();
        System.out.println(solution.reversePrefix("xyzxe", 'z'));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reversePrefix(String word, char ch) {
            int idx = 0;
            char[] chars = word.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                if (chars[i] == ch) {
                    idx = i;
                    break;
                }
            }
            for (int i = 0; i < idx; i++, idx--) {
                char t = chars[i];
                chars[i] = chars[idx];
                chars[idx] = t;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}