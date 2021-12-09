package leetcode.editor.cn;

//794、有效的井字游戏
class ValidTicTacToeState {
    public static void main(String[] args) {
        Solution solution = new ValidTicTacToeState().new Solution();
        String[] b = {"X  ", "   ", "   "};
        boolean b1 = solution.validTicTacToe(b);
        System.out.println(b1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validTicTacToe(String[] board) {
            int xCount = 0, oCount = 0;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    char ch = board[i].charAt(j);
                    if (ch == 'X') {
                        xCount++;
                    } else if (ch == 'O') {
                        oCount++;
                    }
                }
            }
            //数量不一致
            if (oCount > xCount || Math.abs(xCount - oCount) > 1) {
                return false;
            }
            //O胜
            if (oCount != 0 && isVictory(board, 'O')) {
                if (oCount != xCount || isVictory(board, 'X')) {
                    return false;
                }
            }
            //X胜
            if (xCount != 0 && isVictory(board, 'X')) {
                if (xCount - oCount != 1 || isVictory(board, 'O')) {
                    return false;
                }
            }
            return true;
        }

        public boolean isVictory(String[] board, char ch) {
            if (ch == 'O') {
                if (board[0].equals("OOO") || board[1].equals("OOO") || board[2].equals("OOO")) {
                    return true;
                }
            } else {
                if (board[0].equals("XXX") || board[1].equals("XXX") || board[2].equals("XXX")) {
                    return true;
                }
            }
            if (board[0].charAt(0) == ch && board[1].charAt(0) == ch && board[2].charAt(0) == ch
                    || board[0].charAt(1) == ch && board[1].charAt(1) == ch && board[2].charAt(1) == ch
                    || board[0].charAt(2) == ch && board[1].charAt(2) == ch && board[2].charAt(2) == ch
                    || board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch
                    || board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) {
                return true;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}