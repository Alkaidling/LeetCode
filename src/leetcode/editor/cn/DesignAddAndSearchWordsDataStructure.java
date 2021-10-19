package leetcode.editor.cn;

import java.util.HashSet;

//211、添加与搜索单词 - 数据结构设计
class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //TODO
    // 字典树

    //Time Limit Exceeded
    class WordDictionary {
        HashSet<String> set;

        public WordDictionary() {
            set = new HashSet<>();
        }

        public void addWord(String word) {
            set.add(word);
        }

        public boolean search(String word) {
            boolean res = true;
            if(set.contains(word)){
                return true;
            }else {
                for (String s : set) {
                    res = true;
                    if (s.length() == word.length()) {
                        for (int i = 0; i < word.length(); i++) {
                            if(word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)){
                                res = false;
                                break;
                            }
                        }
                        if (res) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}