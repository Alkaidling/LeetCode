package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 041、滑动窗口的平均值
class QIsx9U {
    public static void main(String[] args) {
        MovingAverage movingAverage = new QIsx9U().new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        int size;
        Deque<Integer> queue;
        double sum;

        public MovingAverage(int size) {
            this.size = size;
            queue = new ArrayDeque<>();
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if (queue.size() > size) {
                int num = queue.poll();
                sum -= num;
            }
            return sum / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}