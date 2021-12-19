package leetcode.editor.cn;

import java.util.*;

//997、找到小镇的法官
class FindTheTownJudge {
    public static void main(String[] args) {
        Solution solution = new FindTheTownJudge().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findJudge(int n, int[][] trust) {
            if (trust.length == 0) {
                return n == 1 ? 1 : -1;
            }
            int[] map = new int[n + 1];
            boolean[] set = new boolean[n + 1];
            for (int[] ints : trust) {
                map[ints[1]]++;
                set[ints[0]] = true;
            }
            for (int i = 0; i <= n; i++) {
                if(map[i] == n - 1 && !set[i]){
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}