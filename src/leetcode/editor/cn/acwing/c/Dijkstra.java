package leetcode.editor.cn.acwing.c;

import java.util.*;
import java.io.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/04 14:30
 * @ClassName Dijkstra
 * @Description: 朴素Dijkstra算法
 */
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]); //n个点
        int m = Integer.parseInt(s[1]); //m条边

        int[][] g = new int[n + 1][n + 1];  //邻接矩阵
        for (int i = 0; i <= n; i++) {      //初始化
            Arrays.fill(g[i],0x3f3f);
            g[i][i] = 0;  //自己到自己的距离为0
        }
        while (m-- > 0) {
            s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);
            g[a][b] = Math.min(g[a][b], c);   //邻接矩阵只保留a和b之间最短的边，且如果自环的话即a=b，则路径仍为0
        }

        int t = dijkstra(g,n);

        System.out.println(t);
    }

    private static int dijkstra(int[][] g, int n) {  //g为邻接矩阵(g.length = n + 1、权值不超过10000、0x3f3f视为+∞)、n为图中点的个数
        int[] dist = new int[n + 1];           //用于存储每个点到起点的最短距离
        boolean[] st = new boolean[n + 1];     //用于在更新最短距离时 判断当前的点的最短距离是否确定 是否需要更新
        Arrays.fill(dist, 0x3f3f);  //所有点的距离初始化为0x3f3f
        dist[1] = 0;
        for (int i = 0; i < n; i++) {  //每次迭代的过程中都先找到当前未确定的最短距离的点中 距离最短的点t
            int t = -1;
            for (int j = 1; j <= n; j++) {
                //该步骤即在 还未确定的点中 找 到起点路径最小的点
                //t必须未确定(不在st集合中)，并且发现有更短的路径时更新t
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);  //1到t的距离 + t到j的边 如果更小则更新1到j的距离
            }
        }
        if (dist[n] == 0x3f3f) {
            return -1;
        }
        return dist[n];
    }
}
