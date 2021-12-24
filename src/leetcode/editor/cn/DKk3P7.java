package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 032、有效的变位词
class DKk3P7 {
    public static void main(String[] args) {
        Solution solution = new DKk3P7().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length() || s.equals(t)) {
                return false;
            }
            int[] cnt = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++) {
                cnt[s.charAt(i) - 'a']++;
                cnt[t.charAt(i) - 'a']--;
            }
            for (int i : cnt) {
                if(i != 0){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}