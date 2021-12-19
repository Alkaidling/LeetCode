package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 015、字符串中的所有变位词
class VabMRr {
    public static void main(String[] args) {
        Solution solution = new VabMRr().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] cnt = new int[26];
            for (char ch : p.toCharArray()) {
                cnt[ch - 'a']++;
            }
            ArrayList<Integer> res = new ArrayList<>();
            char[] chars = s.toCharArray();
            int n = s.length(), m = p.length();
            int i = 0, j = 0;
            while (j < n) {
                if (j - i < m) {
                    cnt[chars[j] - 'a']--;
                    j++;
                }else {
                    if(isEmpty(cnt)){
                        res.add(i);
                    }
                    cnt[chars[i] - 'a']++;
                    i++;
                }
            }
            if(isEmpty(cnt)){
                res.add(i);
            }
            return res;
        }

        private boolean isEmpty(int[] cnt) {
            for (int i : cnt) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}