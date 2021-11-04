package leetcode.editor.cn.acwing.c;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/04 17:55
 * @ClassName Floyd
 * @Description: 854. Floyd求最短路
 */
public class Floyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                }
                else {
                    d[i][j] = 0x3f3f3f3f;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            d[a][b] = Math.min(d[a][b], w);
        }

        floyd(d,n);

        while (q-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (d[a][b] > 0x3f3f3f3f / 2) {
                System.out.println("impossible");
            }
            else {
                System.out.println(d[a][b]);
            }
        }
    }

    private static void floyd(int[][] d,int n) {  //d邻接矩阵、n点个数，修改邻接矩阵的值，将∞更新为最短路径
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}
