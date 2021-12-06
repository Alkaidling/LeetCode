package leetcode.editor.cn;

//剑指 Offer 39、数组中出现次数超过一半的数字
class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int vote = 1;
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                if (vote == 0) {
                    res = nums[i];
                }
                if (nums[i] == res) {
                    vote++;
                }else {
                    vote--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}