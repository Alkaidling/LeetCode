package leetcode.editor.cn;

import java.util.*;

//169、多数元素
class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,2,1,2,2,3,3,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == res) {
                    cnt++;
                }else {
                    cnt--;
                    if (cnt < 0) {
                        res = nums[i];
                        cnt = 1;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}