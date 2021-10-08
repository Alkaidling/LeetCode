package leetcode.editor.cn;

import java.util.*;

//187、重复的DNA序列
class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        String s = "AAAAAAAAAAAAA";
        List<String> repeatedDnaSequences = solution.findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //hash表 + 滑动窗口 O(nl)
        public List<String> findRepeatedDnaSequences(String s) {
            ArrayList<String> list = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            if (s.length() < 10) {
                return list;
            }
            for (int i = 0; i <= s.length()-10; i++) {
                String str = s.substring(i, i+10);
                map.put(str, map.getOrDefault(str, 0) + 1);
                if (map.get(str) == 2) {
                    list.add(str);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}