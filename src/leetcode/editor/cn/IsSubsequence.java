package leetcode.editor.cn;

//392、判断子序列
class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
        boolean subsequence = solution.isSubsequence("a", "");
        System.out.println(subsequence);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // dp

        //O(max(m,n))
        public boolean isSubsequence(String s, String t) {
            int i = 0,j = 0;
            for (; i < t.length() && j < s.length(); i++) {
                if(s.charAt(j) == t.charAt(i)){
                    j++;
                }
            }
            return j == s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}