package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 065、最短的单词编码
class ISwD2y {
    public static void main(String[] args) {
        Solution solution = new ISwD2y().new Solution();
        solution.minimumLengthEncoding(new String[]{"time", "me", "bell"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Trie{
            Trie[] children;
            int count;
            public Trie(){
                children = new Trie[26];
                count = 0;
            }
            public Trie get(char c) {
                if (children[c - 'a'] == null) {
                    children[c - 'a'] = new Trie();
                    count++;
                }
                return children[c - 'a'];
            }
        }
        public int minimumLengthEncoding(String[] words) {
            Trie trie = new Trie();
            HashMap<Trie, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                Trie cur = trie;
                for (int j = word.length() - 1; j >= 0; --j) {
                    cur = cur.get(word.charAt(j));
                }
                map.put(cur, i);
            }
            int res = 0;
            for (Map.Entry<Trie, Integer> entry : map.entrySet()) {
                if (entry.getKey().count == 0) {
                    res += words[entry.getValue()].length() + 1;
                }
            }
            return res;
        }
        public int minimumLengthEncoding0(String[] words) {
            HashSet<String> set = new HashSet<>(Arrays.asList(words));
            for (String word : words) {
                for (int i = 1; i < word.length(); i++) {
                    set.remove(word.substring(i));
                }
            }
            int res = 0;
            for (String s : set) {
                res += s.length() + 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}