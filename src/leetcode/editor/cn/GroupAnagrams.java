package leetcode.editor.cn;

import java.util.*;

//49、字母异位词分组
class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        long start = System.currentTimeMillis();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        long end = System.currentTimeMillis();
        System.out.println(lists);
        System.out.println(end - start);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            ArrayList<List<String>> lists = new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String s = sortString(str);
                if(!map.containsKey(s)){
                    ArrayList<String> list = new ArrayList<>();
                    map.put(s,list);
                    lists.add(list);
                }
                List<String> list = map.get(s);
                list.add(str);
            }
            return lists;
        }

        public String sortString(String str){
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}