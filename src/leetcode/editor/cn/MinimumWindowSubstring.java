package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//76、最小覆盖子串
class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        //String s = solution.minWindow("aBbaBBBBA", "BBA");
        //String s = solution.minWindow("bba", "ba");
        String s = solution.minWindow("abcabdebac", "cda");
        //String s = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        public String minWindow(String s, String t) {
            StringBuilder sb = new StringBuilder(s);
            StringBuilder tb = new StringBuilder(t);
            String min1 = getMin(s,t);
            String min2 = getMin(sb.reverse().toString(),tb.reverse().toString());
            if (min2.length() < min1.length()) {
                return new StringBuilder(min2).reverse().toString();
            }else {
                return min1;
            }
        }

        public String getMin(String s, String t) {
            String min = "";
            HashMap<Character, Integer> map1 = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            }
            char[] chars = s.toCharArray();
            int n = chars.length;
            int x1 = -1;
            int x2 = -1;
            HashMap<Character, Integer> map2 = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char ch = chars[i];
                if (map1.containsKey(ch)) {
                    queue.offer(i);
                    map2.put(ch, map2.getOrDefault(ch, 0) + 1);
                    if (x1 == -1) {
                        x1 = queue.isEmpty() ? -1 : queue.poll();
                    } else {
                        if (x2 == -1) {
                            x2 = queue.isEmpty() ? -1 : queue.poll();
                        }
                    }
                }
                if (x1 != -1) {
                    if (check(map1, map2, chars[x1])) {
                        String s1 = s.substring(x1, i + 1);
                        if (min.length() != 0) {
                            min = min.length() > s1.length() ? s1 : min;
                        } else {
                            min = s1;
                        }
                        x1 = x2;
                        x2 = queue.isEmpty() ? -1 : queue.poll();
                    }
                }
            }
            return min;
        }

        private boolean check(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2, char x1) {
            if (map2.size() < map1.size()) {
                return false;
            }
            for (char ch : map1.keySet()) {
                if (map1.get(ch) > map2.get(ch)) {
                    return false;
                }
            }
            map2.put(x1, map2.get(x1) - 1);
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}