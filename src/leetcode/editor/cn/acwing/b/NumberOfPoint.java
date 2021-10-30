package leetcode.editor.cn.acwing.b;

import java.io.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-30 16:59
 * @ClassName NumberOfPoint
 * @Description: 837. 连通块中点的数量
 */

public class NumberOfPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        UnionFind unionFind = new UnionFind(n);
        while (m-- > 0) {
            String[] str = reader.readLine().split(" ");
            if(str[0].equals("C")){
                int a = Integer.parseInt(str[1]);
                int b = Integer.parseInt(str[2]);
                unionFind.union(a-1,b-1);
            }else if(str[0].equals("Q1")){
                int a = Integer.parseInt(str[1]);
                int b = Integer.parseInt(str[2]);
                int rootA = unionFind.find(a - 1);
                int rootB = unionFind.find(b - 1);
                if (rootA == rootB) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }else if(str[0].equals("Q2")){
                int a = Integer.parseInt(str[1]);
                int count = unionFind.getCount(a - 1);
                System.out.println(count);
            }
        }

        reader.close();
    }
    static class UnionFind {
        private int[] count;
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                count[i] = 1;
            }
        }

        public int find(int i){
            if(i != parent[i]){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                    count[rootX] += count[rootY];
                }else if(rank[rootX] < rank[rootY]){
                    parent[rootX] = rootY;
                    count[rootY] += count[rootX];
                }else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                    count[rootX] += count[rootY];
                }
            }
        }

        public int getCount(int x) {
            int rootX = find(x);
            return count[rootX];
        }
    }
}
