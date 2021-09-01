package leetcode.editor.cn;

import java.util.concurrent.locks.ReentrantReadWriteLock;

//Java：165、比较版本号

class CompareVersionNumbers {
    public static void main(String[] args) {
        Solution solution = new CompareVersionNumbers().new Solution();
        String s1 = "1.1";
        String s2 = "1.10";
        int i = solution.compareVersion1(s1, s2);
        System.out.println(i);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //双指针
        //将.之间的字符串转换为整数
        //version1.charAt(i) - '0' 跳过为0的前缀
        public int compareVersion1(String version1, String version2) {
            int n = version1.length(), m = version2.length();
            int i = 0, j = 0;
            while (i < n || j < m) {
                int x = 0;
                for (; i < n && version1.charAt(i) != '.'; ++i) {
                    x = x * 10 + version1.charAt(i) - '0';
                }
                ++i; // 跳过点号
                int y = 0;
                for (; j < m && version2.charAt(j) != '.'; ++j) {
                    y = y * 10 + version2.charAt(j) - '0';
                }
                ++j; // 跳过点号
                if (x != y) {
                    return x > y ? 1 : -1;
                }
            }
            return 0;
        }

    //分割字符串

    //字符串分隔函数split 返回string[]
    //Integer.parseInt(String s) 将字符串参数解析为带符号的十进制整数。(跳过为0的前缀，输出整数)
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}