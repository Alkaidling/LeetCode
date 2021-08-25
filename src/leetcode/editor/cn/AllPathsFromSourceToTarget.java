package leetcode.editor.cn;


import java.util.*;

//Java：797、所有可能的路径
class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceToTarget().new Solution();
        int[][] graph = {{1,2},{3},{3},{}};
        //System.out.println(graph.length);
        List<List<Integer>> lists = solution.allPathsSourceTarget(graph);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);  //尾插尾取，将stack的结果add到list中，保证栈中顺序与结果的顺序相同
        dfs(graph, 0, graph.length - 1);
        return lists;
    }

    //DFS
    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            lists.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}