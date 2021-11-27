package leetcode.editor.cn;


import sun.font.FontRunIterator;

//Java：剑指 Offer 12、矩阵中的路径
class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        //char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        //char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board ={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        //String word = "BCCED";
        //String word = "ABCESEEEFS";
        String word = "AAB";
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] visit = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == word.charAt(0) && dfs(visit, board, word, 0, i, j)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(boolean[][] visit, char[][] board, String word, int index, int row, int col) {
            if (index == word.length()) {
                return true;
            }
            int m = board.length;
            int n = board[0].length;
            if (row == m || col == n || row < 0 || col < 0 || board[row][col] != word.charAt(index) || visit[row][col]) {
                return false;
            }
            visit[row][col] = true;
            boolean flag =  dfs(visit, board, word, index + 1, row + 1, col)
                        || dfs(visit, board, word, index + 1, row, col + 1)
                        || dfs(visit, board, word, index + 1, row - 1, col)
                        || dfs(visit, board, word, index + 1, row, col - 1);
            visit[row][col] = false;
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}