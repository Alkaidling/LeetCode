package leetcode.editor.cn;

//剑指 Offer 44、数字序列中某一位的数字
class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            long start = 1;
            long count = 9;
            while (n > count) {
                n -= count;
                digit += 1;
                start *= 10;
                count = digit * start * 9;
            }
            long num = start + (n - 1) / digit;
            int res = Long.toString(num).charAt((n - 1) % digit) - '0';
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}