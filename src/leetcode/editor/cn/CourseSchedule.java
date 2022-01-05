package leetcode.editor.cn;

import java.util.*;

//207、课程表
class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        int[][] p = {{1,0}};
        System.out.println(solution.canFinish(2, p));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] in = new int[numCourses];
            HashMap<Integer,List<Integer>> map = new HashMap<>();
            int res = 0;
            for (int[] ints : prerequisites) {
                in[ints[0]]++;
                if (!map.containsKey(ints[1])) {
                    ArrayList<Integer> list = new ArrayList<>();
                    map.put(ints[1],list);
                }
                List<Integer> list = map.get(ints[1]);
                list.add(ints[0]);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    res++;
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                if (!map.containsKey(x)) {
                    continue;
                }
                for (int i : map.get(x)) {
                    in[i]--;
                    if (in[i] == 0) {
                        res++;
                        queue.offer(i);
                    }
                }
            }
            return res == numCourses;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}