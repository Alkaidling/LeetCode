package leetcode.editor.cn;


import java.util.*;

//剑指 Offer II 063、替换单词
class UhWRSj {
    public static void main(String[] args) {
        Solution solution = new UhWRSj().new Solution();
        String s = solution.replaceWords(Arrays.asList("ac","ab"), "it is abnormal that this solution is accepted");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            for (String s : dictionary) {
                trie.insert(s);
            }
            String[] s = sentence.split(" ");
            StringBuilder builder = new StringBuilder();
            for (String str : s) {
                builder.append(trie.preWord(str));
                builder.append(" ");
            }
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }

        class Trie {
            Trie[] children;
            String word;

            public Trie() {
                children = new Trie[26];
            }

            public void insert(String word) {
                Trie node = this;
                for (char ch : word.toCharArray()) {
                    int x = ch - 'a';
                    if (node.children[x] == null) {
                        node.children[x] = new Trie();
                    }
                    node = node.children[x];
                }
                node.word = word;
            }

            //返回字典中str的前缀，若无则返回str本身
            public String preWord(String str) {
                Trie node = this;
                for (char ch : str.toCharArray()) {
                    int x = ch - 'a';
                    if (node.word != null) {
                        return node.word;  //前缀
                    }
                    if (node.children[x] == null) {
                        return str;  //无前缀
                    }
                    node = node.children[x];
                }
                return str;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}