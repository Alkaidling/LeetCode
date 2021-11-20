package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//594、最长和谐子序列
class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
        int[] nums = {1, 1, 1, 1};
        int lhs = solution.findLHS(nums);
        System.out.println(lhs);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //排序 O(nlogn)
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int begin = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] - nums[begin] > 1) {
                    begin++;
                }
                if (nums[i] - nums[begin] == 1) {
                    res = Math.max(res, i - begin + 1);
                }
            }
            return res;
        }

        //哈希表 O(n)
        public int findLHS0(int[] nums) {
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();  //以key为起点的最长和谐子序列长度
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                if (map.containsKey(key + 1)) {
                    res = Math.max(entry.getValue() + map.get(key + 1), res);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}