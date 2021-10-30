package leetcode.editor.cn;

//208、实现 Trie (前缀树)
class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                int x = chars[i] - 'a';
                if (node.children[x] == null) {
                    node.children[x] = new Trie();
                }
                node = node.children[x];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            //Trie node = searchPrefix(word);
            //return node != null && node.isEnd;
            Trie node = this;
            char[] chars = word.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                int x = chars[i] - 'a';
                if(node.children[x] == null){
                    return false;
                }
                node = node.children[x];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            //return searchPrefix(prefix) != null;
            Trie node = this;
            char[] chars = prefix.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                int x = chars[i] - 'a';
                if(node.children[x] == null){
                    return false;
                }
                node = node.children[x];
            }
            return true;
        }

        //private Trie searchPrefix(String prefix) {
        //    Trie node = this;
        //    char[] chars = prefix.toCharArray();
        //    int n = chars.length;
        //    for (int i = 0; i < n; i++) {
        //        int x = chars[i] - 'a';
        //        if(node.children[x] == null){
        //            return null;
        //        }
        //        node = node.children[x];
        //    }
        //    return node;
        //}
    }

    //二维数组实现字典树（空间开销大，插入查询次数多的话执行慢）
    //class Trie {
    //    private int[][] son;
    //    private boolean[] flag;
    //    private int head;
    //    public Trie() {
    //        son = new int[100009][26];
    //        flag = new boolean[100009];
    //    }
    //
    //    public void insert(String word) {
    //        char[] chars = word.toCharArray();
    //        int n = chars.length;
    //        int p = 0;
    //        for (int i = 0; i < n; i++) {
    //            int u = chars[i] - 'a';
    //            if (son[p][u] == 0) {
    //                son[p][u] = ++head;
    //            }
    //            p = son[p][u];
    //        }
    //        flag[p] = true;
    //    }
    //
    //    public boolean search(String word) {
    //        char[] chars = word.toCharArray();
    //        int n = chars.length;
    //        int p = 0;
    //        for (int i = 0; i < n; i++) {
    //            int u = chars[i] - 'a';
    //            if(son[p][u] == 0){
    //                return false;
    //            }
    //            p = son[p][u];
    //        }
    //        return flag[p];
    //    }
    //
    //    public boolean startsWith(String prefix) {
    //        char[] chars = prefix.toCharArray();
    //        int n = chars.length;
    //        int p = 0;
    //        for (int i = 0; i < n; i++) {
    //            int u = chars[i] - 'a';
    //            if(son[p][u] == 0){
    //                return false;
    //            }
    //            p = son[p][u];
    //        }
    //        return true;
    //    }
    //}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}