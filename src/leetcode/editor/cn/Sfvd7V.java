package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 033、变位词组
class Sfvd7V {
    public static void main(String[] args) {
        Solution solution = new Sfvd7V().new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> lists = new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String s = sort(str);
                if (!map.containsKey(s)) {
                    ArrayList<String> list = new ArrayList<>();
                    map.put(s,list);
                }
                List<String> list = map.get(s);
                list.add(str);
            }
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                lists.add(entry.getValue());
            }
            return lists;
        }

        public String sort(String str){
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}