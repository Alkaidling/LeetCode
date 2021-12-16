package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer II 004、只出现一次的数字
class WGki4K {
    public static void main(String[] args) {
        Solution solution = new WGki4K().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int singleNumber(int[] nums) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                int total = 0;
                for (int num : nums) {
                    total += ((num >> i) & 1);
                }
                if (total % 3 != 0) {
                    res |= (1 << i);
                }
            }
            return res;
        }

        public int singleNumber0(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0)+1);
            }
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == 1) {
                    return e.getKey();
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}