package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 062、实现前缀树
class QC3q1f {
    public static void main(String[] args) {
        Trie trie = new QC3q1f().new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        Trie[] children;
        Boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char aChar : word.toCharArray()) {
                int x = aChar - 'a';
                if (node.children[x] == null) {
                    node.children[x] = new Trie();
                }
                node = node.children[x];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (char aChar : word.toCharArray()) {
                int x = aChar - 'a';
                if (node.children[x] == null) {
                    return false;
                }
                node = node.children[x];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (char aChar : prefix.toCharArray()) {
                int x = aChar - 'a';
                if (node.children[x] == null) {
                    return false;
                }
                node = node.children[x];
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}