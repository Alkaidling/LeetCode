package leetcode.editor.cn;

//剑指 Offer 65、不用加减乘除做加法
class BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            if (b == 0) {
                return a;
            }
            return add(a ^ b, (a & b) << 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}