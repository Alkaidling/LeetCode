package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 110、所有路径
class BP4bmD {
    public static void main(String[] args) {
        Solution solution = new BP4bmD().new Solution();
        int[][] g = {{1,3},{2},{3},{}};
        System.out.println(solution.allPathsSourceTarget(g));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            dfs(graph,0,list,lists);
            return lists;
        }

        private void dfs(int[][] graph, int idx, ArrayList<Integer> list, ArrayList<List<Integer>> lists) {
            if (idx == graph.length - 1) {
                lists.add(new ArrayList<>(list));
                return;
            }
            for (int i : graph[idx]) {
                list.add(i);
                dfs(graph,i,list,lists);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}