package leetcode.editor.cn;

//318、最大单词长度乘积
class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int i = solution.maxProduct(words);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(String[] words) {
            int n = words.length;
            int[] hash = new int[n];
            int res = 0;
            //位运算，存储每个字符信息
            for (int i = 0; i < n; i++) {
                for (char c : words[i].toCharArray()) {
                    hash[i] |= 1 << c - 'a';
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((hash[i] & hash[j]) == 0) {
                        res = Math.max(res, words[i].length() * words[j].length());
                    }
                }
            }
            return res;
        }

        //O(n³)
        public int maxProduct1(String[] words) {
            int n = words.length;
            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (notHaveSaveChar(words[i], words[j])) {
                        res = Math.max(words[i].length() * words[j].length(), res);
                    }
                }
            }
            return res;
        }

        //word和word1是否不含有相同字母
        private boolean notHaveSaveChar(String word, String word1) {
            for (int i = 0; i < word.length(); i++) {
                if (word1.contains(word.charAt(i) + "")) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}