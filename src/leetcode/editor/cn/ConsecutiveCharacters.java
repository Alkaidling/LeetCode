package leetcode.editor.cn;

//1446、连续字符
class ConsecutiveCharacters {
    public static void main(String[] args) {
        Solution solution = new ConsecutiveCharacters().new Solution();
        int cc = solution.maxPower("c");
        System.out.println(cc);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPower(String s) {
            int n = s.length();
            int res = 1, len = 1, start = 0;
            for (int i = 1; i < n; i++) {
                if(s.charAt(i) == s.charAt(start)){
                    len++;
                }else {
                    start = i;
                    len = 1;
                }
                res = Math.max(res,len);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}