package leetcode.editor.cn;

//剑指 Offer II 005、单词长度的最大乘积
class AseY1I {
    public static void main(String[] args) {
        Solution solution = new AseY1I().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int n = words.length;
            boolean[][] flag = new boolean[n][26];
            for (int i = 0; i < n; i++) {
                for (char ch : words[i].toCharArray()) {
                    flag[i][ch - 'a'] = true;
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int k = 0;
                    for (; k < 26; k++) {
                        if(flag[i][k] && flag[j][k]){
                            break;
                        }
                    }
                    if (k == 26) {
                        res = Math.max(res,words[i].length() * words[j].length());
                    }
                }
            }
            return res;
        }

        public int maxProduct1(String[] words) {
            int n = words.length;
            int[] masks = new int[n];
            for (int i = 0; i < n; i++) {
                for (char ch : words[i].toCharArray()) {
                    masks[i] |= 1 << (ch - 'a');
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((masks[i] & masks[j]) == 0) {
                        res = Math.max(res,words[i].length() * words[j].length());
                    }
                }
            }
            return res;
        }


        public int maxProduct0(String[] words) {
            int[] ch = new int[26];
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                for (char c : words[i].toCharArray()) {
                    ch[c - 'a']++;
                }
                for (int j = i + 1; j < words.length; j++) {
                    boolean flag = true;
                    for (char c : words[j].toCharArray()) {
                        if (ch[c - 'a'] != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        res = Math.max(res,words[i].length() * words[j].length());
                    }
                }
                for (char c : words[i].toCharArray()) {
                    ch[c - 'a']--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}