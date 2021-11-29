package leetcode.editor.cn;

import java.util.Arrays;

//剑指 Offer 61、扑克牌中的顺子
class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        boolean straight = solution.isStraight(new int[]{0,0,0,9,11});
        System.out.println(straight);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int count = nums[0] == 0 ? 1 : 0;
            for (int i = 1; i < 5; i++) {
                if(nums[i] == 0){
                    count++;
                }else if(nums[i] == nums[i-1]){
                    return false;
                }
            }
            return nums[4] - nums[count] < 5; // 最大牌 - 最小牌 < 5
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}