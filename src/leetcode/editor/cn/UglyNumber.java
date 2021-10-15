package leetcode.editor.cn;

//263、丑数
class UglyNumber {
    public static void main(String[] args) {
        Solution solution = new UglyNumber().new Solution();
        boolean ugly = solution.isUgly(1026);
        System.out.println(ugly);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }
            while (n > 1) {
                if (n % 2 == 0) {
                    n /= 2;
                } else if (n % 3 == 0) {
                    n /= 3;
                } else if (n % 5 == 0) {
                    n /= 5;
                } else {
                    return false;
                }
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}