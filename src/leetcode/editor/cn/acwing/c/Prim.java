package leetcode.editor.cn.acwing.c;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/05 13:46
 * @ClassName Prim
 * @Description:
 */
public class Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);  //n个点
        int m = Integer.parseInt(s[1]);  //m条边
        int[][] g = new int[n + 1][n + 1];   //邻接矩阵
        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], 0x3f3f3f3f);
            g[i][i] = 0;
        }
        while (m-- > 0) {
            s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);
            g[a][b] = g[b][a] = Math.min(c, g[a][b]);
        }

        int t = prim(g, n);

        if (t == 0x3f3f3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }
    }

    private static int prim(int[][] g, int n) { //g:邻接矩阵（1到n），n:点的个数
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, 0x3f3f3f3f);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {  //在所有未加到集合中找出路径最小的点
                    t = j;
                }
            }
            if (i != 0 && dist[t] == 0x3f3f3f3f) {  //非连通图
                return 0x3f3f3f3f;
            }
            if (i != 0) {
                res += dist[t];
            }
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);  //用最小的t点更新其他所有点的路径
            }
            st[t] = true; //将t加到集合中
        }
        return res;
    }
}
