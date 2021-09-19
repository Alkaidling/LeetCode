package leetcode.editor.cn;


//Java：剑指 Offer 12、矩阵中的路径
class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        //char[][] board ={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "ABCCED";
        //String word = "AAB";
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int index = 0;
        boolean result = false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visit = new boolean[row][col];  //visit数组表示此位置元素是否被访问过。可省略visit数组，直接修改board中的值
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)){
                    result = findNext(visit,board,i,j,word,index);
                    if(result){
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private boolean findNext(boolean[][] visit, char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if(row >= 0 && col >= 0 && row < board.length && col < board[0].length && !visit[row][col] && board[row][col] == word.charAt(index)){
            index++;
            visit[row][col] = true;
            hasPath = findNext(visit,board, row+1, col, word, index)
                    || findNext(visit,board, row, col+1, word, index)
                    || findNext(visit,board, row-1, col, word, index)
                    || findNext(visit,board, row, col-1, word, index);
            if (!hasPath) {
                index--;
                visit[row][col] = false;
            }
        }
        return hasPath;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}