package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 114、外星文字典
class Jf1JuT {
    public static void main(String[] args) {
        Solution solution = new Jf1JuT().new Solution();
        System.out.println(solution.alienOrder(new String[]{"wrt","wrtkj"}));
        System.out.println(solution.alienOrder(new String[]{"abc","ab"}));
        System.out.println(solution.alienOrder(new String[]{"z","x","a","zb","zx"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alienOrder(String[] words) {
            StringBuilder sb = new StringBuilder();
            Set<Integer>[] lists = new Set[26];
            int[] in = new int[26];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < 26; i++) {
                lists[i] = new HashSet<>();
            }
            for (int i = 0; i < words.length; i++) {
                String word1 = words[i];
                for (int idx = 0; idx < word1.length(); idx++) {
                    set.add(word1.charAt(idx) - 'a');
                }
                for (int j = i + 1; j < words.length; j++) {
                    String word2 = words[j];
                    if (word1.equals(word2)) {
                        continue;
                    }
                    int idx = 0;
                    while (idx < word1.length() && idx < word2.length() && word1.charAt(idx) == word2.charAt(idx)) {
                        idx++;
                    }
                    if (idx == word2.length() && idx < word1.length()) {
                        return "";
                    }
                    if(idx < word1.length() && idx < word2.length() && !lists[word1.charAt(idx) - 'a'].contains(word2.charAt(idx) - 'a')){
                        in[word2.charAt(idx) - 'a']++;
                        lists[word1.charAt(idx) - 'a'].add(word2.charAt(idx) - 'a');
                    }
                }
            }
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < 26; i++) {
                if (set.contains(i) && in[i] == 0) {
                    queue.offer(i);
                    sb.append((char)(i + 'a'));
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                Set<Integer> list = lists[x];
                for (int i : list) {
                    in[i]--;
                    if (in[i] == 0) {
                        queue.offer(i);
                        sb.append((char)(i + 'a'));
                    }
                }
            }
            return sb.length() < set.size() ? "" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}