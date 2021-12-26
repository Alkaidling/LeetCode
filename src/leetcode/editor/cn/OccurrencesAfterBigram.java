package leetcode.editor.cn;

import java.util.*;

//1078、Bigram 分词
class OccurrencesAfterBigram {
    public static void main(String[] args) {
        Solution solution = new OccurrencesAfterBigram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            String[] strings = text.split(" ");
            ArrayList<String> list = new ArrayList<>();
            for (int i = 1; i < strings.length; i++) {
                if (i < strings.length - 1 && strings[i].equals(second) && strings[i - 1].equals(first)) {
                    list.add(strings[i + 1]);
                }
            }
            return list.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}