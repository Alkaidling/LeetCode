package leetcode.editor.cn;
//Java：292、Nim 游戏
class NimGame {
    public static void main(String[] args) {
        Solution solution = new NimGame().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}