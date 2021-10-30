package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//137、只出现一次的数字 II
class SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO

        //哈希表
        //执行耗时:7 ms,击败了5.28% 的Java用户 内存消耗:38.1 MB,击败了40.08% 的Java用户
        public int singleNumber(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            int res = 0;
            for (int num : map.keySet()) {
                if(map.get(num) == 1){
                    res = num;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}