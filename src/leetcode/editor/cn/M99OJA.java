package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 086、分割回文子字符串
class M99OJA {
    public static void main(String[] args) {
        Solution solution = new M99OJA().new Solution();
        solution.partition("google");
        System.out.println(solution.lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList<List<String>> lists = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        int n;
        boolean[][] dp;
        public String[][] partition(String s) {
            n = s.length();
            dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if(s.charAt(i) == s.charAt(j)){
                        //if (j - i == 1) {
                        //    dp[i][j] = true;
                        //}else {
                        //    dp[i][j] = dp[i + 1][j - 1];
                        //}
                        dp[i][j] = j - i == 1 || dp[i + 1][j - 1];
                    }
                }
            }

            dfs(s,0);

            String[][] res = new String[lists.size()][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new String[lists.get(i).size()];
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = lists.get(i).get(j);
                }
            }
            return res;
        }

        private void dfs(String s, int i) {
            if(i == n){
                lists.add(new ArrayList<>(list));
                return;
            }
            for (int j = i; j < n; j++) {
                if(dp[i][j]){
                    list.add(s.substring(i,j + 1));
                    dfs(s,j + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}