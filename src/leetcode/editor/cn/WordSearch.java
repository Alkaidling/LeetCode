package leetcode.editor.cn;

import java.util.*;

//79、单词搜索
class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        System.out.println(solution.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "abcd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visit;
        String word;
        char[][] board;
        int[] x = {1, 0, -1, 0};
        int[] y = {0, -1, 0, 1};

        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            this.word = word;
            this.board = board;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        visit = new boolean[m][n];
                        visit[i][j] = true;
                        if (dfs(i, j, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int index) {
            if (index == word.length() - 1){
                return true;
            }
            for (int l = 0; l < 4; l++) {
                int nextX = x[l] + i;
                int nextY = y[l] + j;
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length || visit[nextX][nextY]) {
                    continue;
                }
                if (board[nextX][nextY] != word.charAt(index + 1)) {
                    continue;
                }
                visit[nextX][nextY] = true;
                if(dfs(nextX, nextY, index + 1)){
                    return true;
                }
                visit[nextX][nextY] = false;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}