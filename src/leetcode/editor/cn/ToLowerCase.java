package leetcode.editor.cn;

//709、转换成小写字母
class ToLowerCase {
    public static void main(String[] args) {
        Solution solution = new ToLowerCase().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toLowerCase(String s) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] |= 32;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}