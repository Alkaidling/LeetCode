package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 073、狒狒吃香蕉
class NZZqjQ {
    public static void main(String[] args) {
        Solution solution = new NZZqjQ().new Solution();
        solution.minEatingSpeed(new int[]{30,11,23,4,20},5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = 0;
            for (int pile : piles) {
                max = Math.max(pile,max);
            }
            int left = 1, right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if(!possible(piles,mid,h)){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return left;
        }

        private boolean possible(int[] piles, int speed, int h) {
            int cnt = 0;
            for (int pile : piles) {
                cnt += (pile - 1) / speed + 1;
            }
            return cnt <= h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}