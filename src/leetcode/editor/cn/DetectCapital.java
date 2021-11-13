package leetcode.editor.cn;

//520、检测大写字母
class DetectCapital {
    public static void main(String[] args) {
        Solution solution = new DetectCapital().new Solution();
        boolean usa = solution.detectCapitalUse("leetcode");
        System.out.println(usa);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            char[] chars = word.toCharArray();
            int n = chars.length;
            int highCount = 0;
            for (char ch : chars) {
                if(Character.isUpperCase(ch)){
                    highCount++;
                }
            }
            if (highCount == 1) {
                return Character.isUpperCase(chars[0]);
            }else {
                return highCount == n || highCount == 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}