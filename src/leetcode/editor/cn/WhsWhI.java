package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 119、最长连续序列
class WhsWhI {
    public static void main(String[] args) {
        Solution solution = new WhsWhI().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {
                   int cur = num;
                   int len = 1;
                    while (set.contains(cur + 1)) {
                        cur++;
                        len++;
                    }
                    res = Math.max(res,len);
                }
            }
            return res;
        }

        public int longestConsecutive0(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    int left = map.getOrDefault(num - 1,0);
                    int right = map.getOrDefault(num + 1,0);
                    int len = right + left + 1;
                    res = Math.max(res,len);
                    map.put(num,len);
                    map.put(num - left,len);  //左边界
                    map.put(num + right,len); //右边界
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}