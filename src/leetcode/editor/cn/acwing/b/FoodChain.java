package leetcode.editor.cn.acwing.b;

import java.io.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-31 15:39
 * @ClassName FoodChain
 * @Description: 240. 食物链
 */

public class FoodChain {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = read.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        UnionFind uf = new UnionFind(n);

        int res = 0;
        while (k-- > 0) {
            s = read.readLine().split(" ");
            int t = Integer.parseInt(s[0]), x = Integer.parseInt(s[1]), y = Integer.parseInt(s[2]);

            if (x > n || y > n) res++;
            else if (t == 1) res += (uf.D1(x, y) == true ? 0 : 1);
            else if (t == 2) res += (uf.D2(x, y) == true ? 0 : 1);
        }
        log.write(res + "\n");
        log.flush();
    }

    static class UnionFind {
        private int[] parent;
        private int[] d;
        private static final int M = 3;

        public UnionFind(int n) {
            parent = new int[n+1];
            d = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;  //初始化，根节点都是自己
            }
        }

        //查找i节点的根节点
        public int find(int i) {
            if (i != parent[i]) {
                int u = find(parent[i]);
                d[i] = (d[i] + d[parent[i]]) % M;    // 注意这里一定要取模，不然这个距离可能会大于 M
                parent[i] = u;
                //d[i] = (d[i] + d[parent[i]]) % M;
                //parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        // 判断 x y 到底是不是同类
        public boolean D1(int x, int y) {
            int r1 = find(x), r2 = find(y);

            // x 和 y 已经处理
            if (r1 == r2) return d[x] % M == d[y] % M;

            parent[r2] = r1;
            d[r2] = (d[x] - d[y] + M) % M;
            return true;
        }

        // x 能吃 y 吗 ？
        public boolean D2(int x, int y) {
            int r1 = find(x), r2 = find(y);

            if (r1 == r2) return d[x] % M == (d[y] + 1) % M;

            parent[r2] = r1;
            d[r2] = ((d[x] - d[y] - 1) + M) % M;
            return true;
        }
    }
}
