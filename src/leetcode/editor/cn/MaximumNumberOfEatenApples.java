package leetcode.editor.cn;

import java.util.*;

//1705、吃苹果的最大数目
class MaximumNumberOfEatenApples {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEatenApples().new Solution();
        int[] a = {1, 2, 3, 5, 2};
        int[] d = {3, 2, 1, 4, 2};
        int i = solution.eatenApples(a, d);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public int eatenApples(int[] apples, int[] days) {
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int n = days.length;
            int res = 0;
            for (int i = 0; i < n || !heap.isEmpty(); i++) {
                if (i < n && apples[i] != 0) {
                    heap.offer(new int[]{apples[i], days[i] + i});  //苹果个数、过期日期
                }
                while (!heap.isEmpty() && heap.peek()[1] <= i) {
                    heap.poll();
                }
                if (!heap.isEmpty()) {
                    res++;
                    int[] ints = heap.poll();
                    if (ints[0] > 1) {
                        ints[0]--;
                        heap.offer(ints);
                    }
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}