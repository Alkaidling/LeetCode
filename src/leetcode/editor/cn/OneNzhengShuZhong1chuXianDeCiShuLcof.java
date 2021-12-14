package leetcode.editor.cn;

//剑指 Offer 43、1～n 整数中 1 出现的次数
class OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            long mulk = 1;
            int res = 0;
            while (n >= mulk) {
                res += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
                mulk *= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}