package leetcode.editor.cn;
//Java：剑指 Offer 05、替换空格
class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        String s = solution.replaceSpace(" ");
        System.out.println(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ' '){
                builder.append(ch);
            }else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}