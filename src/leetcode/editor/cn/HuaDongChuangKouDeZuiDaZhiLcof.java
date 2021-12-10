package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

//剑指 Offer 59 - I、滑动窗口的最大值
class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] ints = solution.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //O(nlogn)
        public int[] maxSlidingWindow1(int[] nums, int k) {
            int n = nums.length;
            if (n == 0) {
                return new int[0];
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);  //大顶堆
            int[] res = new int[n - k + 1];
            for (int i = 0; i < k - 1; i++) {  //预先向窗口里添加k-1个数
                heap.offer(nums[i]);
            }
            for (int i = 0; i < res.length; i++) {
                heap.offer(nums[i + k - 1]);  //添加窗口右边界的值
                res[i] = heap.peek();
                heap.remove(nums[i]);  //删除左边界的值
            }
            return res;
        }

        //O(n)
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();  //单调队列
            int n = nums.length;
            if (n == 0) {
                return new int[0];
            }
            int[] res = new int[n - k + 1];
            for (int i = 0, j = 1 - k; i < n; i++, j++) {  //j为窗口右边界，i为窗口左边界
                // 当前的最大值如果超过窗口的左边界则出队
                if (j > 0 && queue.peek() == nums[j - 1]) {
                    queue.poll();
                }
                while (!queue.isEmpty() && queue.peekLast() < nums[i]) {  //单调递减队列
                    queue.removeLast();
                }
                queue.offer(nums[i]);
                // 记录窗口最大值
                if (j >= 0) {
                    res[j] = queue.peek();
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}