package leetcode.editor.cn;
//434、字符串中的单词数
class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if((i > 0 && s.charAt(i) != ' ' && s.charAt(i-1) == ' ') || (i == 0 && s.charAt(i) != ' ')){
                num++;
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}