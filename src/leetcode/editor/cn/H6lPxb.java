package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 117、相似的字符串
class H6lPxb {
    public static void main(String[] args) {
        Solution solution = new H6lPxb().new Solution();
        System.out.println(solution.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] f;
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;

            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int fi = find(i), fj = find(j);
                    if (fi == fj) {
                        continue;
                    }
                    if(check(strs[i],strs[j])){
                        f[fi] = fj;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (f[i] == i) {
                    res++;
                }
            }
            return res;
        }

        private boolean check(String a, String b) {
            int num = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    num++;
                    if (num > 2) {
                        return false;
                    }
                }
            }
            return true;
        }

        private int find(int i) {
            if(i != f[i]){
                f[i] = find(f[i]);
            }
            return f[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}