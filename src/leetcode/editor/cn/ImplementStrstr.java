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

    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) {
                j++;
            }
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) {
                j++;
            }
            // 整一段匹配成功，直接返回下标
            if (j == m) {
                return i - j;
            }
        }
        return -1;

        //int i = 0,j = 0;
        //while (i < s.length && j < p.length) {
        //    if(s[i] == p[j]) {  //字串与原串匹配，同时后移
        //        i++;
        //        j++;
        //    } else if (next[j] == -1) {  //等价于j==0，即来到的字串的开头位置，需要将原串后移，进行新的匹配
        //        i++;
        //    } else {  //⭐⭐⭐⭐⭐字串与原串不匹配时，j位置从0向前跳最大前后缀字串的长度，再与i进行比较。⭐⭐⭐⭐⭐
        //        j = next[j];
        //    }
        //}
        ////j越界则为匹配成功
        //return j == p.length ? i - j : -1;
    }


    public int strStr2(String haystack, String needle) {
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