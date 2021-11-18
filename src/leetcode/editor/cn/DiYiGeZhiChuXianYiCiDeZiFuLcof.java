package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//剑指 Offer 50、第一个只出现一次的字符
class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        char c = solution.firstUniqChar("abaccdeff");
        System.out.println(c);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //一次遍历，直接找
        public char firstUniqChar(String s) {
            char res = ' ';
            int min = Integer.MAX_VALUE;
            for (char c = 'a'; c <= 'z'; c++) {
                int index = s.indexOf(c);
                if (index != -1 && index == s.lastIndexOf(c) && index < min) {
                    min = index;
                    res = c;
                }
            }
            return res;
        }

        //LinkedHashMap O(n) + O(26)
        public char firstUniqChar3(String s) {
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            char[] chars = s.toCharArray();
            for (char ch : chars) {
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return ' ';
        }

        //hash表 O(n) + O(n)
        public char firstUniqChar2(String s) {
            HashMap<Character, Integer> countMap = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char ch : chars) {
                countMap.put(ch, countMap.getOrDefault(ch,0) + 1);
            }
            for (char ch : chars) {
                if (countMap.get(ch) == 1) {
                    return ch;
                }
            }
            return ' ';
        }

        //数组存储信息O(n) + O(n)
        public char firstUniqChar0(String s) {
            int[] nums = new int[26];
            char[] chars = s.toCharArray();
            for (char ch : chars) {
                nums[ch - 'a']++;
            }
            for (char ch : chars) {
                if (nums[ch - 'a'] == 1) {
                    return ch;
                }
            }
            return ' ';
        }

        //数组存储信息O(n) + O(26)
        public char firstUniqChar1(String s) {
            int[] nums = new int[26];
            int[] index = new int[26];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                nums[chars[i] - 'a']++;
                if (index[chars[i] - 'a'] == 0) {
                    index[chars[i] - 'a'] = i + 1;
                }
            }
            int ix = Integer.MAX_VALUE;
            char res = ' ';
            for (int i = 0; i < 26; i++) {
                if (nums[i] == 1 && index[i] < ix) {
                    ix = index[i];
                    res = (char) (i + 'a');
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}