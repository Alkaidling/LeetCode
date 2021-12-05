package leetcode.editor.cn;

import java.util.Arrays;

//剑指 Offer 56 - I、数组中数字出现的次数
class ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        int[] nums = {1,2,10,4,4,3,3,10};
        // 2    : 0010
        //10    : 1010
        //2^10  : 1000
        int[] ints = solution.singleNumbers(nums);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int x = 0;
            int y = 0;
            int t = 0;  // t = x ^ y
            for (int num : nums) {
                t ^= num;
            }
            t &= -t;    // 求出t最右边的1
            for (int num : nums) {
                if ((num & t) == 0) {
                    y ^= num;
                }else {
                    x ^= num;
                }
            }
            return new int[]{x,y};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}