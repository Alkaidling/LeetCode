package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 116、省份数量
class BLyHh0 {
    public static void main(String[] args) {
        Solution solution = new BLyHh0().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dfs
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visit = new boolean[n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                if(!visit[i]){
                    dfs(isConnected,visit,i);
                    res++;
                }
            }
            return res;
        }

        private void dfs(int[][] isConnected, boolean[] visit, int i) {
            int n = isConnected.length;
            for (int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1 && !visit[j]){
                    visit[j] = true;
                    dfs(isConnected,visit,j);
                }
            }
        }

        public int findCircleNum0(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && isConnected[i][j] == 1) {
                        unionFind.union(i,j);
                    }
                }
            }
            return unionFind.getCount();
        }
        private class UnionFind{
            private int count;
            private int[] parent;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
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
                    parent[rootY] = rootX;
                    count--;
                }
            }

            public int getCount() {
                return count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}