package leetcode.editor.cn;
//Java：实现 strStr()
class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();

        String haystack = "mississippi";
        String needle = "issipi";

        //String haystack = "aaaaa";
        //String needle = "bba";

        //String haystack = "hello";
        //String needle = "ll";
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();

        int i = solution.strStr1(haystack, needle);
        System.out.println(i);


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.length()==0)
            return 0;

        int i = 0,j = 0,k = 0;
        while (i <= haystack.length() && j <= needle.length()){
            if(i == haystack.length() || j == needle.length())
                break;
            if(haystack.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                if(i == haystack.length() || j == needle.length())
                    break;
            }else {
                j = 0;
                i = ++k;
            }
        }
        if(j == needle.length())
            return k;
        else
            return -1;
    }
    //暴力匹配
    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}