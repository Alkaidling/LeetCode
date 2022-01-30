package leetcode.editor.cn;

import java.util.*;

//884、两句话中的不常见单词
class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            String[] ss1 = s1.split(" ");
            String[] ss2 = s2.split(" ");
            Map<String,Integer> map1 = new HashMap<>();
            Map<String,Integer> map2 = new HashMap<>();
            for (String s : ss1) {
                map1.put(s, map1.getOrDefault(s,0) + 1);
            }
            for (String s : ss2) {
                map2.put(s, map2.getOrDefault(s,0) + 1);
            }
            ArrayList<String> list = new ArrayList<>();
            for (String s : map1.keySet()) {
                if (map1.get(s) == 1 && !map2.containsKey(s)) {
                    list.add(s);
                }
            }
            for (String s : map2.keySet()) {
                if (map2.get(s) == 1 && !map1.containsKey(s)) {
                    list.add(s);
                }
            }
            String[] res = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}