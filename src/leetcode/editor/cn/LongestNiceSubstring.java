package leetcode.editor.cn;

import java.util.*;

//1763、最长的美好子字符串
class LongestNiceSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestNiceSubstring().new Solution();
        System.out.println(solution.longestNiceSubstring("dDzeE"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestNiceSubstring(String s) {
            int len = 0;
            int l = -1, r = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    String str = s.substring(i, j + 1);
                    if(check(str.toCharArray()) && str.length() >= len){
                        len = str.length();
                        l = i;
                        r = j;
                    }
                }
            }
            return l == -1 ? "" : s.substring(l,r + 1);
        }

        public boolean check(char[] chars){
            HashSet<Character> set1 = new HashSet<>();
            HashSet<Character> set2 = new HashSet<>();
            for (char ch : chars) {
                set1.add(ch);
                set2.add(Character.toLowerCase(ch));
            }
            return set1.size() == set2.size() * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}