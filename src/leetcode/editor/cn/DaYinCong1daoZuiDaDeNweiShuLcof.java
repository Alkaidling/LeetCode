package leetcode.editor.cn;

//剑指 Offer 17、打印从1到最大的n位数
class DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int max = (int) Math.pow(10, n) - 1;
            int[] res = new int[max];
            for (int i = 0; i < max; i++) {
                res[i] = i + 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}