package leetcode.editor.cn;

import java.util.Arrays;

//Java：787、K 站中转内最便宜的航班
class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        Solution solution = new CheapestFlightsWithinKStops().new Solution();
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int n = 3;
        int cheapestPrice = solution.findCheapestPrice(3, flights, 0, 2, 1);
        System.out.println(cheapestPrice);


/*        int[][] A = new int[n][n];
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                A[i][j] = solution.findA(n,flights,i,j);
                path[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int x = 0; x < n; ++x) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (A[i][j] > A[i][x] + A[x][j] && i!=j && A[i][x]!=Integer.MAX_VALUE && A[x][j]!=Integer.MAX_VALUE) {
                        A[i][j] = A[i][x] + A[x][j];
                        path[i][j] = x;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            final int INF = 10000 * 101 + 1;
            //f[t][i] 表示从src到 i 中转t次的最少价格
            int[][] f = new int[k + 1][n];
            //初始化为最大值
            for (int i = 0; i < k + 1; ++i) {
                Arrays.fill(f[i], INF);
            }
            //单独处理k == 0 的情况，就是不需要中转
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                if (j == src) {
                    f[0][i] = cost;
                }
            }
            for (int t = 1; t < k + 1; ++t) {
                for (int[] flight : flights) {
                    int j = flight[0], i = flight[1], cost = flight[2];
                    //从后往前推，从j中转第t次到达i的最少价格
                    f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
                }
            }
            int ans = INF;
            //遍历最多经过 k 站中转的路线，获取最少价格
            for (int t = 0; t <= k; ++t) {
                ans = Math.min(ans, f[t][dst]);
            }
            return ans == INF ? -1 : ans;
        }

        /*//弗洛伊德算法 可求任意顶点间的最短路径
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] A = new int[n][n];     //A为邻接矩阵，即任意两个节点间最短路径的长度
        int[][] path = new int[n][n];  //path记录当前两顶点间最短路径要经过的中间节点

        //初始化A、path
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                A[i][j] = findA(n,flights,i,j);
                path[i][j] = -1;
            }
        }

        //以x为顶点对所有的顶点对{i,j}进行检测和修改
        for (int x = 0; x < n; ++x) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (A[i][j] > A[i][x] + A[x][j] && i!=j && A[i][x]!=Integer.MAX_VALUE && A[x][j]!=Integer.MAX_VALUE){
                        A[i][j] = A[i][x] + A[x][j];
                        path[i][j] = x;
                    }
                }
            }
        }

        //求中间经过k站的最短路径

        return -1;
    }

        //求src到dst的权并返回
    public int findA(int n,int[][] flights,int src,int dst){
        if(src == dst)
            return 0; //同顶点权为0

        for (int i = 0; i < n; i++) {
            if(flights[i][0] == src){
                if(flights[i][1] == dst)
                    return flights[i][2];
            }
        }

        return Integer.MAX_VALUE;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}