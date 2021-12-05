package leetcode.editor.cn;

import java.util.HashMap;

//剑指 Offer 56 - II、数组中数字出现的次数 II
class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //哈希表
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0)+1);
            }
            for(int key : map.keySet()){
                if (map.get(key) == 1) {
                    return key;
                }
            }
            return nums[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}