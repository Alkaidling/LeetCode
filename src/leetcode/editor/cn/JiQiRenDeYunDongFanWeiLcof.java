package leetcode.editor.cn;

import java.util.ArrayDeque;

//Java：剑指 Offer 13、机器人的运动范围
class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        int i = solution.movingCount(20, 23, 8);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //DFS
        public int movingCount(int m, int n, int k) {
            boolean[][] visit = new boolean[m][n];
            return dfs(visit,m, n, k, 0, 0);
        }
        private int dfs(boolean[][] visit, int m, int n, int k, int row, int col) {
            int count = 0;
            if (getSum(row,col) <= k && row >= 0 && row < m && col >= 0 && col < n && !visit[row][col]) {
                visit[row][col] = true;
                count = 1 + dfs(visit,m, n, k, row + 1, col) + dfs(visit,m, n, k, row, col + 1);
            }
            return count;
        }
        private int getSum(int row, int col){
            int temp = 0;
            while (row > 0 || col > 0) {
                temp = temp + row % 10 + col % 10;
                row /= 10;
                col /= 10;
            }
            return temp;
        }

        //BFS
        //执行耗时:4 ms,击败了22.44% 的Java用户 内存消耗:35.7 MB,击败了29.82% 的Java用户
        public int movingCount1(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }
            int res = 0;
            int[] x = {1, 0, -1, 0};
            int[] y = {0, 1, 0, -1};
            boolean[][] visit = new boolean[m][n];
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.push(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int row = node[0] + x[i];
                    int col = node[1] + y[i];
                    if (row >= 0 && col >= 0 && row < m && col < n && !visit[row][col] && getSum(row,col) <= k) {
                        queue.offer(new int[]{row, col});
                        visit[row][col] = true;
                        res++;
                    }
                }
            }
            return res;
        }


        public int movingCount0(int m, int n, int k) {
            boolean[][] visit = new boolean[m][n];
            return visitCount(visit, m, n, 0, 0, k);
        }

        private int visitCount(boolean[][] visit, int m, int n, int row, int col, int k) {
            int count = 0;
            if (row / 10 + row % 10 + col / 10 + col % 10 <= k && row >= 0 && col >= 0 && row < m && col < n && !visit[row][col]) {
                visit[row][col] = true;
                count = 1 + visitCount(visit, m, n, row + 1, col, k)
                        + visitCount(visit, m, n, row, col + 1, k);
                //+ visitCount(visit,m,n,row-1,col,k)
                //+ visitCount(visit,m,n,row,col-1,k); //只需往下遍历，不考虑多条路径（剑指 Offer 12）
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}