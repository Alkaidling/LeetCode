package leetcode.editor.cn;

//1816、截断句子
class TruncateSentence {
    public static void main(String[] args) {
        Solution solution = new TruncateSentence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String truncateSentence(String s, int k) {
            int count = 0,i = 0;
            for (; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == ' '){
                    count++;
                }
                if(count == k){
                    break;
                }
            }
            return s.substring(0,i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}