package leetcode.editor.cn;

//剑指 Offer 64、求1+2+…+n
class Qiu12nLcof {
    public static void main(String[] args) {
        Solution solution = new Qiu12nLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNums(int n) {
            boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}