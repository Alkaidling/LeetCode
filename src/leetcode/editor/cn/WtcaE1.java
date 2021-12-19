package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 016、不含重复字符的最长子字符串
class WtcaE1 {
    public static void main(String[] args) {
        Solution solution = new WtcaE1().new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(abcabcbb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int res = 0;
            int left = 0;  //left为滑动窗口左边界，i为滑动窗口右边界
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(chars[i]) || map.get(chars[i]) < left) {  //不含重复值 或 重复值不包含在窗口内
                    res = Math.max(i - left + 1, res);
                }else { //窗口[left,i]里含有重复值
                    left = map.get(chars[i]) + 1;  //移动左边界到重复值的右边
                }
                map.put(chars[i],i);  //更新重复值的位置
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}