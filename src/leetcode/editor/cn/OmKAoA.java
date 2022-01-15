package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 094、最少回文分割
class OmKAoA {
    public static void main(String[] args) {
        Solution solution = new OmKAoA().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n  = s.length();
            boolean[][] g = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(g[i],true);
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
                }
            }
            int[] f = new int[n];
            Arrays.fill(f,Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                if(g[0][i]){
                    f[i] = 0;
                }else {
                    for (int j = 0; j < i; j++) {
                        if(g[j + 1][i]){
                            f[i] = Math.min(f[i],f[j] + 1);
                        }
                    }
                }
            }
            return f[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}