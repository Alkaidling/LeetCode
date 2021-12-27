package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//139、单词拆分
class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        boolean b = solution.wordBreak1(s, wordDict);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dp
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet();
            int max = 0;
            for (String s1 : wordDict) {
                wordDictSet.add(s1);
                max = Math.max(max,s1.length());
            }
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i; j >= 0 && j >= i - max; j--) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {  //dp[i]= dp[j] && check(s[j..i−1])  (dp[j]:0到j合法，check(s[j..i−1]):检查j到i-1是否合法 )
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }


        //记忆化回溯
        public boolean wordBreak1(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet(wordDict);
            int[] memory = new int[s.length()];
            return dfs(s, wordDictSet, 0, memory);
        }

        private boolean dfs(String s, Set<String> wordDictSet, int start, int[] memory) {
            int n = s.length();
            if (start == n) {
                return true;
            }
            if(memory[start] != 0){
                return memory[start] == 1 ? true : false;
            }
            boolean res = false;
            for (int i = start + 1; i <= n; i++) {
                String substr = s.substring(start, i);
                if (wordDictSet.contains(substr)) {
                    res = dfs(s, wordDictSet, i,memory);
                }
                if (res) {
                    memory[start] = 1;
                    return true;
                }
            }
            memory[start] = 2;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}