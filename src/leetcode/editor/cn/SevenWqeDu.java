package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 057、值和下标之差都在给定的范围内
class SevenWqeDu {
    public static void main(String[] args) {
        Solution solution = new SevenWqeDu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Long low = set.floor((long) nums[i]);
                if(low != null && low >= (long) nums[i] - t){
                    return true;
                }
                Long upper = set.ceiling((long) nums[i]);
                if(upper != null && upper <= (long) nums[i] + t){
                    return true;
                }
                set.add((long) nums[i]);
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}