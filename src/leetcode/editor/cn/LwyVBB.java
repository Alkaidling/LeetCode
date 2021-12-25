package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 034、外星语言是否排序
class LwyVBB {
    public static void main(String[] args) {
        Solution solution = new LwyVBB().new Solution();
        boolean b = solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] cnt;
        public boolean isAlienSorted(String[] words, String order) {
            cnt = new int[26];
            int index = 1;
            for (char c : order.toCharArray()) {
                cnt[c - 'a'] = index++;
            }
            for (int i = 1; i < words.length; i++) {
                if(!isValid(words[i - 1],words[i])){
                    return false;
                }
            }
            return true;
        }

        //word2的字典序是否比word1大
        private boolean isValid(String word1, String word2) {
            int i = 0;
            for (; i < word1.length() && i < word2.length(); i++) {
                if(cnt[word1.charAt(i) - 'a'] < cnt[word2.charAt(i) - 'a']){
                    return true;
                }else if(cnt[word1.charAt(i) - 'a'] > cnt[word2.charAt(i) - 'a']){
                    return false;
                }
            }
            return i == word1.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}