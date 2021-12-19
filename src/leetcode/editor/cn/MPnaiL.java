package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 014、字符串中的变位词
class MPnaiL {
    public static void main(String[] args) {
        Solution solution = new MPnaiL().new Solution();
        boolean b = solution.checkInclusion("adc", "dcda");
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //O(m+26*n)
        public boolean checkInclusion(String s1, String s2) {
            int[] map = new int[26];
            for (char ch : s1.toCharArray()) {
                map[ch - 'a']++;
            }
            char[] chars = s2.toCharArray();
            int n = chars.length, m = s1.length();
            int i = 0, j = 0;
            while (j < n){
                if(j - i < m){
                    map[chars[j] - 'a']--;
                    j++;
                }else {
                    if(isEmpty(map)){
                        return true;
                    }
                    map[chars[i] - 'a']++;
                    i++;
                }
            }
            return isEmpty(map);
        }

        private boolean isEmpty(int[] t) {
            for (int i : t) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}