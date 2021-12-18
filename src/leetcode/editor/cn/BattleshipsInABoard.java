package leetcode.editor.cn;

import java.util.*;

//419、甲板上的战舰
class BattleshipsInABoard {
    public static void main(String[] args) {
        Solution solution = new BattleshipsInABoard().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBattleships(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == 'X'){
                        if(i > 0 && board[i-1][j] == 'X'){
                            continue;
                        }
                        if(j > 0 && board[i][j - 1] == 'X'){
                            continue;
                        }
                        res++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}