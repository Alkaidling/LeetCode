package leetcode.editor.cn.acwing.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/05 14:45
 * @ClassName Kruskal
 * @Description: 859. Kruskal算法求最小生成树
 */
public class Kruskal {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);  //n个点
        int m = Integer.parseInt(s[1]);  //m条边
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), w = Integer.parseInt(s[2]);
            edges[i] = new Edge(a,b,w);
        }

        int t = kruskal(edges,n,m);

        if (t == -1) {
            System.out.println("impossible");
        }else {
            System.out.println(t);
        }
    }

    private static int kruskal(Edge[] edges, int n, int m) {  //edges：邻接表，n：点个数，m：边个数
        Arrays.sort(edges,(o1, o2) -> o1.w - o2.w);
        UnionFind unionFind = new UnionFind(n+1); //并查集
        int res = 0, cnt = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i].a, b = edges[i].b, w = edges[i].w;
            a = unionFind.find(a);
            b = unionFind.find(b);
            if (a != b) {
                res += w;
                cnt++;
                unionFind.union(a,b);
            }
        }
        if (cnt < n-1) {
            return -1;
        }else {
            return res;
        }
    }
    static class Edge { //邻接表
        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    static class UnionFind {  //并查集
        private int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;  //初始化，根节点都是自己
            }
        }
        //查找i节点的根节点
        public int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);  //路径压缩
            }
            return parent[i];
        }
        //合并x和y所在集合
        public void union(int x, int y) {
            if (x != y) {
                parent[x] = y;
            }
        }
    }
}
