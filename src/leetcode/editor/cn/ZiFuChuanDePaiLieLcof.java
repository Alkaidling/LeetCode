package leetcode.editor.cn;

import java.util.*;

//剑指 Offer 38、字符串的排列
class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        long start = System.currentTimeMillis();
        String[] abcs = solution.permutation("asdfghjk");
        //System.out.println(Arrays.toString(abcs));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            ArrayList<String> list = new ArrayList<>();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            StringBuilder builder = new StringBuilder();
            boolean[] visit = new boolean[s.length()];
            dfs(chars, builder, list, visit);
            return list.toArray(new String[0]);
        }

        public void dfs(char[] chars, StringBuilder builder, ArrayList<String> list, boolean[] visit) {
            if (builder.length() == chars.length) {
                list.add(builder.toString());
            }
            for (int i = 0; i < chars.length; i++) {
                if (visit[i] || (i > 0 && chars[i] == chars[i - 1] && !visit[i - 1])) {
                    continue;
                }
                builder.append(chars[i]);
                visit[i] = true;
                dfs(chars, builder, list, visit);
                builder.deleteCharAt(builder.length() - 1);
                visit[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}