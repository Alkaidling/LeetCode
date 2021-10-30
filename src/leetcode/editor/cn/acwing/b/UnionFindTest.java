package leetcode.editor.cn.acwing.b;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-30 15:05
 * @ClassName UnionFind
 * @Description: 并查集
 */

public class UnionFindTest {
    private static int[] p = new int[100010];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        while (m-- > 0) {
            String s = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (s.equals("M")) {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        public UnionFind(int[] nums) {
            count = 0;
            int n = nums.length;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                count++;
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
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {  //按秩合并
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;  //X,Y所在集合秩相等时，将Y连到X下，X的秩加1
                    rank[rootX]++;
                }
                --count;
            }
        }

        //返回集合个数
        public int getCount() {
            return count;
        }
    }
}
