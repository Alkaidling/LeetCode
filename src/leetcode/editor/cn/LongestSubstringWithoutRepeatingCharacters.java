package leetcode.editor.cn;

import java.util.*;

//3、无重复字符的最长子串
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abba";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口，左侧为left，右侧为i
        //执行耗时:5 ms,击败了82.35% 的Java用户  内存消耗:38.5 MB,击败了48.09% 的Java用户
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    //包含重复元素，则改变滑动窗口的左侧位置（到重复值的下一个元素，若重复值出现在left之前则不改变left位置）
                    //保证多个重复值出现left仍为最左，不包括所有重复值
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;

        }


        //辣鸡方法(遇到重复就跳到重复的下一个字符循环)
        //执行耗时:73 ms,击败了11.83% 的Java用户  内存消耗:39.1 MB,击败了8.44% 的Java用户
        public int lengthOfLongestSubstring1(String s) {
            int ans = 0;
            int len = s.length();
            Map<Character, Integer> map = new HashMap<>();
            int temp = 0;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    ans = Math.max(ans, temp);
                    temp = 0;
                    i = map.get(ch) + 1;
                    map.clear();
                }
                map.put(s.charAt(i), i);
                temp++;
            }
            return Math.max(ans, temp);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}