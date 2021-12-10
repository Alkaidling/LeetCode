package leetcode.editor.cn;

import java.util.ArrayDeque;

//剑指 Offer 59 - II、队列的最大值
class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        MaxQueue maxQueue = new DuiLieDeZuiDaZhiLcof().new MaxQueue();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {
        ArrayDeque<Integer> queue;  //单调递减队列
        int[] nums;
        int pushIndex = 0;
        int popIndex = 0;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            nums = new int[10010];
        }

        public int max_value() {
            if (popIndex >= pushIndex) {
                return -1;
            }
            return queue.peek();
        }

        public void push_back(int value) {
            nums[pushIndex++] = value;
            while (!queue.isEmpty() && value > queue.peekLast()) {
                queue.removeLast();
            }
            queue.addLast(value);
        }

        public int pop_front() {
            if (popIndex >= pushIndex) {
                return -1;
            }
            int val = nums[popIndex++];
            if (val == queue.peek()) {
                queue.poll();
            }
            return val;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}