package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//51、N 皇后
class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] grid = new char[n][n];         // n * n 的棋盘
            boolean[] col = new boolean[n];         //列
            boolean[] dg = new boolean[2 * n - 1];  //对角线（右上到左下的对角线，dg[0]为左上角grid[0][0]的元素，dg[1]为grid[0][1]和gird[1][0]，...）
            boolean[] udg = new boolean[2 * n - 1]; //反对角线（左上到右下的对角线，udg[0]为左下角grid[n-1][0]的元素，ud1[1]为grid[n-2][0]和gird[n-1][1]，...）

            for (int i = 0; i < n; i++) {           //初始化棋盘
                for (int j = 0; j < n; j++) {
                    grid[i][j] = '.';
                }
            }

            List<List<String>> lists = new ArrayList<>();
            List<String> list = new ArrayList<>();
            dfs(0, n, grid, col, dg, udg, lists, list);
            return lists;
        }

        private void dfs(int row, int n, char[][] grid, boolean[] col, boolean[] dg, boolean[] udg, List<List<String>> lists, List<String> list) {
            if (row == n) { //递归到最后一行
                for (int i = 0; i < n; i++) {
                    list.add(new String(grid[i]));  //全部排列完毕、将第i行添加进结果(list)中
                }
                lists.add(new ArrayList<>(list));   //将当前结果list添加进结果集(lists)中
                list.clear();
            } else {
                //当前在第row行，从第0列到n-1列进行循环
                for (int i = 0; i < n; i++) {
                    //当前列、对角线、反对角线有元素则跳过（剪枝）
                    if (col[i] || dg[i + row] || udg[i + n - 1 - row]) {
                        continue;
                    }
                    //当前位置（row = row,col = i）可用
                    grid[row][i] = 'Q';
                    //当前列和对角线设置为ture，即已经用过
                    col[i] = dg[i + row] = udg[i - row + n - 1] = true;
                    //递归进下一行
                    dfs(row + 1, n, grid, col, dg, udg,lists,list);
                    //回溯
                    grid[row][i] = '.';
                    col[i] = dg[i + row] = udg[i - row + n - 1] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}