package leetcode.editor.cn;

import java.util.*;

//851、喧闹和富有
class LoudAndRich {
    public static void main(String[] args) {
        Solution solution = new LoudAndRich().new Solution();
        int[][] r = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        //int[][] r = {{0,1},{1,2}};
        int[] q = {3,2,5,4,6,1,7,0};
        //int[] q = {0,1,2};
        int[] ints = solution.loudAndRich(r, q);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //拓扑排序
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            int[] in = new int[n]; //入度
            for (int[] ints : richer) {
                g[ints[0]].add(ints[1]);
                in[ints[1]]++;
            }
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = i;
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                for (int y : g[x]) {  //y为x的邻接点，即x比y富有
                    if(quiet[res[x]] < quiet[res[y]]){
                        res[y] = res[x];
                    }
                    if (--in[y] == 0) {
                        queue.offer(y);
                    }
                }
            }
            return res;
        }

        int[][] richer;
        int[] quite;

        public int[] loudAndRich0(int[][] richer, int[] quiet) {
            this.quite = quiet;
            this.richer = richer;
            int n = quiet.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                dfs(set);
                int min = n;
                int x = i;
                for (int idx : set) {
                    if (quiet[idx] < min) {
                        min = quiet[idx];
                        x = idx;
                    }
                }
                res[i] = x;
            }
            return res;
        }
        private void dfs(HashSet<Integer> set) {
            boolean flag = false;
            for (int[] ints : richer) {
                if(!set.isEmpty() && set.contains(ints[1]) && !set.contains(ints[0])){
                    set.add(ints[0]);
                    flag = true;
                }
            }
            if (flag) {
                dfs(set);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}