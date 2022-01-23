package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 118、多余的边
class SevenLpjUW {
    public static void main(String[] args) {
        Solution solution = new SevenLpjUW().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class UnionFind{
            int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x){
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y){
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    parent[rootX] = rootY;
                }
            }
        }
        public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;  //n个节点
            UnionFind unionFind = new UnionFind(n + 1);
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                if (unionFind.find(x) != unionFind.find(y)) {
                    unionFind.union(x,y);
                }else {
                    return edge;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}