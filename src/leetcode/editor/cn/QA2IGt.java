package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 113、课程顺序
class QA2IGt {
    public static void main(String[] args) {
        Solution solution = new QA2IGt().new Solution();
        int[] order = solution.findOrder(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(Arrays.toString(order));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] in = new int[numCourses];
            int[] res = new int[numCourses];
            int idx = 0;
            //HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<Integer>[] lists = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int[] ints : prerequisites) {
                in[ints[0]]++;
                lists[ints[1]].add(ints[0]);
                //map.computeIfAbsent(ints[1], k -> new ArrayList<>()).add(ints[0]);
            }
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    res[idx++] = i;
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                //if (!map.containsKey(x)) {
                //    continue;
                //}
                for (int i : lists[x]) {
                    in[i]--;
                    if (in[i] == 0) {
                        queue.offer(i);
                        res[idx++] = i;
                    }
                }
            }
            return idx == numCourses ? res : new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}