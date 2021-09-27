package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//5、最长回文子串
class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = "ac";
        String s1 = solution.longestPalindrome(s);
        System.out.println(s1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Manacher 算法  时间O(n)  空间O(n)
        public String longestPalindrome3(String s) {
            int start = 0, end = -1;
            StringBuffer t = new StringBuffer("#");
            for (int i = 0; i < s.length(); ++i) {
                t.append(s.charAt(i));
                t.append('#');
            }
            t.append('#');
            s = t.toString();

            List<Integer> arm_len = new ArrayList<Integer>();
            int right = -1, j = -1;  //right即之前回文串的最长臂长，也就是在总串s中能到达的最右点，j为此字串的中心点
            for (int i = 0; i < s.length(); ++i) {
                int cur_arm_len; //当前臂长
                if (right >= i) {  //i若在前面的回文串的最长臂长内
                    int i_sym = j * 2 - i;  //i关于中心点的对称点i_sym
                    int min_arm_len = Math.min(arm_len.get(i_sym), right - i);  //i的臂长在right - i（即为i到前回文串边界距离）和i_sym的臂长中的最小值
                    cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len); //将i从最小臂长处往外拓展求出i的真实臂长
                } else {
                    cur_arm_len = expand(s, i, i); //若i没在前面回文串的臂长内，则从i位置由臂长为0开始往外扩
                }
                arm_len.add(cur_arm_len);
                if (i + cur_arm_len > right) {  //若i扩展后能到达的最右点超过right，则重置最右臂长
                    j = i;
                    right = i + cur_arm_len;
                }
                if (cur_arm_len * 2 + 1 > end - start) {  //若i为中心点的字串长度超过end-start，则重置起始位置和结束位置。
                    start = i - cur_arm_len;
                    end = i + cur_arm_len;
                }
            }

            StringBuffer ans = new StringBuffer();
            for (int i = start; i <= end; ++i) {
                if (s.charAt(i) != '#') {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();
        }

        //left到right的回文字串，返回臂长
        public int expand(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return (right - left - 2) / 2;
        }


        //中心扩散算法 时间O(n²)  空间O(1)
        public String longestPalindrome2(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);//字串规模从i=0 -> i=len-1 到 i=len-1 -> i=len-1
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        //中心扩散
        public int expandAroundCenter(String s, int left, int right) {
            //只要相等就把上限+1，下限-1
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1; //返回相等字符串的长度
        }


        //动态规划  时间O(n²)  空间O(n²)
        public String longestPalindrome1(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i..j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            // 初始化：所有长度为 1 的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();
            // 递推开始
            // 先枚举子串长度
            for (int L = 2; L <= len; L++) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (int i = 0; i < len; i++) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    int j = L + i - 1;
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= len) {
                        break;
                    }

                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1]; //状态转移方程
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

        //全排列比较  时间O(n²)  空间O(n²)
        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            char[] ch = s.toCharArray();
            int len = ch.length;
            int[][] dp = new int[len][len];
            dp[0][0] = 1;
            //aba
            for (int i = 1; i < len; i++) {
                int j = 1;
                for (; i + j < len; j++) {
                    if (i - j >= 0 && ch[i - j] == ch[i + j]) {
                        continue;
                    } else {
                        break;
                    }
                }
                dp[i - j + 1][i + j - 1] = j * 2 - 1;
            }
            //abba
            for (int i = 0; i < len; i++) {
                int j = 1;
                if (i + 1 < len && ch[i] == ch[i + 1]) {
                    for (; j + i + 1 < len; j++) {
                        if (i - j >= 0 && ch[i - j] == ch[i + 1 + j]) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    if (i + j < len) {
                        dp[i - j + 1][i + j] = j * 2;
                    }
                }
            }


            int start = 0;
            int end = 0;
            int max = dp[start][end];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}