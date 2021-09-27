package leetcode.editor.cn;

//14、最长公共前缀
class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = {"cir", "car"};
        String s = solution.longestCommonPrefix1(strs);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //纵向扫描
        public String longestCommonPrefix1(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int length = strs[0].length();
            int count = strs.length;
            for (int i = 0; i < length; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < count; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                         return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }


        public String longestCommonPrefix(String[] strs) {
            for (int i = strs[0].length(); i > 0; i--) {
                String str = strs[0].substring(0, i);
                boolean flag = true;
                for (int j = 1; j < strs.length; j++) {
                    if (!strs[j].startsWith(str)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return str;
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}