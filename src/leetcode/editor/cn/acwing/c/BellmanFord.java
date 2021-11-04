package leetcode.editor.cn.acwing.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/04 16:15
 * @ClassName BellmanFord
 * @Description: 853. 有边数限制的最短路
 */
public class BellmanFord {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]); //n个点
        int m = Integer.parseInt(s[1]); //m条边
        int k = Integer.parseInt(s[2]); //最多k条边
        Edge[] edges = new Edge[m+1];
        for (int i = 1; i <= m; i++) {
            s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), w = Integer.parseInt(s[2]);
            edges[i] = new Edge(a,b,w);
        }
        int t = bellmanFord(edges,n,m,k);
        if (t == -0x3f3f3f3f) {
            System.out.println("impossible");
        }else {
            System.out.println(t);
        }
    }
    /**
     * @Description:
     * @param edges 邻接表（a：起点，b：终点，w：权重）
     * @param n 点数
     * @param m 边数
     * @param k 最短距离最大为k
     * @return: {@link int}
     * @Author: Alkaid
     * @Date: 2021/11/4 16:29
     **/
    private static int bellmanFord(Edge[] edges, int n, int m, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,0x3f3f3f3f);
        dist[1] = 0;
        // 进行 k 次 松弛操作
        while (k-- > 0) {
            //每次对dist数组进行一次备份
            //备份原因：每次只会从上一轮的结果里面去改动，不会被本轮改动的值所影响
            int[] copy = Arrays.copyOf(dist,n+1);
            //对每个边进行遍历，找到长度为k的最短距离
            for (int i = 1; i <= m; i++) {
                int a = edges[i].a, b = edges[i].b, w = edges[i].w;
                dist[b] = Math.min(copy[a] + w, dist[b]);
            }
        }
        // 为了防止出现从1到n其实没有路径，但是可以从0x3f3f3f3f通过一个负值进行更新的情况
        if (dist[n] > 0x3f3f3f3f / 2) {
            return -0x3f3f3f3f;
        }else {
            return dist[n];
        }
    }
    static class Edge {
        int a, b, w;
        public Edge(int a, int b, int w){
            this.a = a; this.b = b; this.w = w;
        }
    }
}
