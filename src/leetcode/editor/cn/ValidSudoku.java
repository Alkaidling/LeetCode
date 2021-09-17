package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：36、有效的数独
class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'}
                         ,{'.','9','8','.','.','.','.','6','.'}
                         ,{'8','.','.','.','6','.','.','.','3'}
                         ,{'4','.','.','8','.','3','.','.','1'}
                         ,{'7','.','.','.','2','.','.','.','6'}
                         ,{'.','6','.','.','.','.','2','8','.'}
                         ,{'.','.','.','4','1','9','.','.','5'}
                         ,{'.','.','.','.','8','.','.','7','9'}};

        boolean validSudoku = solution.isValidSudoku(board);
        System.out.println(validSudoku);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //一次遍历    由于数据是固定长度，所以用数组代替哈希表，时间复杂度严格为O(1)
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    int index = c - '0' + 1;
                    rows[i][index]++;
                    columns[index][j]++;
                    subboxes[i/3][j/3][index]++;
                    if(rows[i][index]>1 || columns[index][j]>1 || subboxes[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    //每行每列每单元格的所有数存到hashmap中，并查看是否重复
    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Integer, Integer> map1 = new HashMap<>(); //行
            Map<Integer, Integer> map2 = new HashMap<>(); //列
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int index = board[i][j] - '0';
                    if(map1.containsKey(index)){
                        return false;
                    }
                    map1.put(index,j);
                }
                if(board[j][i] != '.'){
                    int index = board[j][i] - '0';
                    if(map2.containsKey(index)){
                        return false;
                    }
                    map2.put(index,j);
                }
            }
        }
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                Map<Integer, Integer> map = new HashMap<>(); //行
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(board[i+k][j+l] != '.'){
                            int index = board[i+k][j+l] - '0';
                            if(map.containsKey(index)){
                                return false;
                            }
                            map.put(index,j+l);
                        }
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}