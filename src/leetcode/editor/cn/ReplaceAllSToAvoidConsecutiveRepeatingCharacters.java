package leetcode.editor.cn;

import java.util.*;

//1576、替换所有的问号
class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
        System.out.println(solution.modifyString("?zs"));
        System.out.println(solution.modifyString("ubv?w"));
        System.out.println(solution.modifyString("j?qg??b"));
        System.out.println(solution.modifyString("??yw?ipkj?"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String modifyString(String s) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '?') {
                    int pre = -1,next = -1;
                    if (i > 0) {
                         pre = chars[i - 1] - 'a';
                    }
                    if (i < chars.length - 1) {
                        next = chars[i + 1] - 'a';
                    }
                    for (int j = 0; j < 26; j++) {
                        if (j != pre && j != next) {
                            char ch = (char) (j + 'a');
                            chars[i] = ch;
                            break;
                        }
                    }
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}