package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 087、复原 IP 
class ZeroOn3uN {
    public static void main(String[] args) {
        Solution solution = new ZeroOn3uN().new Solution();
        System.out.println(solution.restoreIpAddresses("10203040"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            int n = s.length();
            if (n > 12 || n < 4) {
                return new ArrayList<>();
            }
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < Math.min(4,n - 2); i++) {
                for (int j = i + 1; j < Math.min(i + 4,n - 1); j++) {
                    for (int k = j + 1; k < Math.min(j + 4,n); k++) {
                        if (n - k > 4) {
                            continue;
                        }
                        String[] strs = new String[4];
                        strs[0] = s.substring(0,i + 1);
                        strs[1] = s.substring(i + 1,j + 1);
                        strs[2] = s.substring(j + 1,k + 1);
                        strs[3] = s.substring(k + 1);
                        boolean flag = false;
                        for (String str : strs) {
                            if (str.equals("") || (str.charAt(0) == '0' && !str.equals("0"))) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            continue;
                        }
                        if(Integer.parseInt(strs[0]) <= 255 && Integer.parseInt(strs[0]) >= 0
                                && Integer.parseInt(strs[1]) <= 255 && Integer.parseInt(strs[1]) >= 0
                                && Integer.parseInt(strs[2]) <= 255 && Integer.parseInt(strs[2]) >= 0
                                && Integer.parseInt(strs[3]) <= 255 && Integer.parseInt(strs[3]) >= 0 ){
                            list.add(strs[0] + '.' + strs[1] + '.' + strs[2] + '.' + strs[3]);
                        }
                    }
                }
            }
            return list;
        }

        static final int SEG_COUNT = 4;
        ArrayList<String> list;
        int[] segments = new int[SEG_COUNT];

        public List<String> restoreIpAddresses0(String s) {
            list = new ArrayList<>();
            dfs(s, 0, 0);
            return list;
        }

        private void dfs(String s, int idx, int segStart) {
            if (idx == SEG_COUNT) {
                if (segStart == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < SEG_COUNT; i++) {
                        sb.append(segments[i]);
                        sb.append('.');
                    }
                    list.add(sb.deleteCharAt(sb.length() - 1).toString());
                }
                return;
            }
            if (segStart == s.length()) {
                return;
            }
            if (s.charAt(segStart) == '0') {
                segments[idx] = 0;
                dfs(s, idx + 1, segStart + 1);
            }
            int addr = 0;
            for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
                addr = addr * 10 + (s.charAt(segEnd) - '0');
                if (addr > 0 && addr <= 0xff) {
                    segments[idx] = addr;
                    dfs(s, idx + 1, segEnd + 1);
                } else {
                    break;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}