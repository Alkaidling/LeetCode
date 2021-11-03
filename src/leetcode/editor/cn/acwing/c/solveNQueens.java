package leetcode.editor.cn.acwing.c;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/03 14:15
 * @ClassName solveNQueens
 * @Description: N皇后问题
 */
public class solveNQueens {
    static char[][] grid;
    static boolean[] dg, udg, col;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        grid = new char[n][n];
        dg = new boolean[n * 2];
        udg = new boolean[n * 2];
        col = new boolean[n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        dfs(0);
    }

    private static void dfs(int row) {
        if (row == n) {
            for (int i = 0; i < n; i++) {
                System.out.println(grid[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || dg[i + row] || udg[i - row + n - 1]) {
                continue;
            }
            grid[row][i] = 'Q';
            col[i] = dg[i + row] = udg[i - row + n - 1] = true;
            dfs(row + 1);
            col[i] = dg[i + row] = udg[i - row + n - 1] = false;
            grid[row][i] = '.';
        }
    }
}
