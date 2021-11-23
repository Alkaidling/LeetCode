package leetcode.editor.cn;

import java.util.HashMap;

//剑指 Offer 48、最长不含重复字符的子字符串
class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        int i = solution.lengthOfLongestSubstring(" ");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:6 ms,击败了48.44% 的Java用户 内存消耗:38.5 MB,击败了44.32% 的Java用户
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int left = 0;
            int res = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    left = Math.max(left, map.get(ch) + 1);
                }
                map.put(ch, i);
                res = Math.max(res, i - left + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}