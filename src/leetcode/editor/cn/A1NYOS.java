package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 011、0 和 1 个数相同的子数组
class A1NYOS {
    public static void main(String[] args) {
        Solution solution = new A1NYOS().new Solution();
        int[] n = {1,0,1,0,1,0,1,0,1,0};
        int maxLength = solution.findMaxLength(n);
        System.out.println(maxLength);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int sum = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] == 0 ? -1 : 1;
                if(map.containsKey(sum)){
                    res = Math.max(res,i - map.get(sum));
                }else {
                    map.put(sum,i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}