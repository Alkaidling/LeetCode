package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 111、计算除法
class VlzXQL {
    public static void main(String[] args) {
        Solution solution = new VlzXQL().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class UnionFind {
            private final int[] parent;
            private final double[] weight;

            public UnionFind(int n) {
                parent = new int[n];
                weight = new double[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    weight[i] = 1.0d;
                }
            }

            public void union(int x,int y, double val){
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return;
                }
                parent[rootX] = rootY;
                weight[rootX] = weight[y] * val / weight[x];
            }

            public int find(int x) {
                if(x != parent[x]){
                    int rootX = parent[x];
                    parent[x] = find(parent[x]);
                    weight[x] *= weight[rootX];
                }
                return parent[x];
            }

            public double isConnected(int x,int y){
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return weight[x] / weight[y];
                }else {
                    return -1.0d;
                }
            }
        }
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int n = equations.size();
            HashMap<String, Integer> map = new HashMap<>(2 * n);
            UnionFind unionFind = new UnionFind(2 * n);
            int id = 0;
            for (int i = 0; i < n; i++) {
                String v1 = equations.get(i).get(0);
                String v2 = equations.get(i).get(1);
                if (!map.containsKey(v1)) {
                    map.put(v1,id++);
                }
                if (!map.containsKey(v2)) {
                    map.put(v2,id++);
                }
                unionFind.union(map.get(v1),map.get(v2),values[i]);
            }

            double[] res = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String v1 = queries.get(i).get(0);
                String v2 = queries.get(i).get(1);
                if (!map.containsKey(v1) || !map.containsKey(v2)) {
                    res[i] = -1.0d;
                }else {
                    res[i] = unionFind.isConnected(map.get(v1),map.get(v2));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}