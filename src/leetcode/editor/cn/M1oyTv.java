package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 017、含有所有字符的最短字符串
class M1oyTv {
    public static void main(String[] args) {
        Solution solution = new M1oyTv().new Solution();
        String s = solution.minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> cnt = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int count = map.size();
            int n = s.length();
            int valid = 0;
            int start = 0, end = 0;
            int ansL = 0, ansR = Integer.MAX_VALUE;
            while (end < n) {
                char ch = s.charAt(end);
                end++;
                if (map.containsKey(ch)) {
                    cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
                    if (cnt.get(ch).equals(map.get(ch))) {
                        valid++;
                    }
                }
                while (valid == count) {
                    if (end - start < ansR - ansL) {
                        ansL = start;
                        ansR = end;
                    }
                    char c = s.charAt(start);
                    start++;
                    if (map.containsKey(c)) {
                        if (cnt.get(c).equals(map.get(c))) {
                            valid--;
                        }
                        cnt.put(c, cnt.getOrDefault(c, 0) - 1);
                    }
                }
            }
            return ansR == Integer.MAX_VALUE ? "" : s.substring(ansL,ansR);
        }


        public String minWindow0(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> cnt = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int n = s.length(), m = t.length();
            int len = n + 1;
            int ansL = -1, ansR = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(chars[i])) {
                    cnt.put(chars[i], cnt.getOrDefault(chars[i], 0) + 1);
                }
                while (check(map, cnt)) {
                    if (i - left + 1 < len) {
                        ansL = left;
                        ansR = i;
                        len = i - left + 1;
                    }
                    if (map.containsKey(chars[left])) {
                        cnt.put(chars[left], cnt.get(chars[left]) - 1);
                    }
                    left++;
                }
                while (left < n && !map.containsKey(chars[left])) {
                    left++;
                }
            }
            if (check(map, cnt) && n - left < len) {
                ansL = left;
                ansR = n - 1;
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
        }

        private boolean check(HashMap<Character, Integer> map, HashMap<Character, Integer> cnt) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (cnt.getOrDefault(key, 0) < value) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}