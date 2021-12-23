package leetcode.editor.cn;

import java.util.*;

//686、重复叠加字符串匹配
class RepeatedStringMatch {
    public static void main(String[] args) {
        Solution solution = new RepeatedStringMatch().new Solution();
        int i = solution.repeatedStringMatch("abcd", "dabcda");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int repeatedStringMatch(String a, String b) {
            StringBuilder builder = new StringBuilder();
            int res = 0;
            while (builder.length() < a.length() + b.length()) {
                builder.append(a);
                res++;
                if (builder.toString().contains(b)) {
                    return res;
                }
            }
            return -1;
        }

        public int repeatedStringMatch0(String a, String b) {
            int index = b.indexOf(a);
            int res = 0;
            if (index == -1) {
                if(a.contains(b)){
                    return 1;
                }else {
                    a += a;
                    if(a.contains(b)){
                        return 2;
                    }else {
                        return -1;
                    }
                }
            }else {
                if (index > 0) {
                    int i = a.length() - 1,j = index - 1;
                    while (j >= 0) {
                        if(a.charAt(i) != b.charAt(j)){
                            return -1;
                        }
                        i--;
                        j--;
                    }
                    res++;
                }
            }
            int i = 0 ,j = index;
            while (j < b.length()) {
                if (i == a.length()) {
                    i = 0;
                }
                if (i == 0) {
                    res++;
                }
                if(a.charAt(i) != b.charAt(j)){
                    return -1;
                }
                j++;
                i++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}