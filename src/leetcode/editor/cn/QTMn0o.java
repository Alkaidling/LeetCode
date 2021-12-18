package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 010、和为 k 的子数组
class QTMn0o {
    public static void main(String[] args) {
        Solution solution = new QTMn0o().new Solution();
        int[] n = {-1, -1, 1};
        int i = solution.subarraySum(n, 0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int res = 0;
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();  //key：前缀和 ，value：数量
            map.put(0, 1);
            for (int num : nums) {
                sum += num;
                res += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}