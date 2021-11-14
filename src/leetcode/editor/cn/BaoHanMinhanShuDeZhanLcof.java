package leetcode.editor.cn;

import java.util.ArrayDeque;

//剑指 Offer 30、包含min函数的栈
class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        MinStack minStack = new BaoHanMinhanShuDeZhanLcof().new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.push(3);
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    //执行耗时:16 ms,击败了99.96% 的Java用户 内存消耗:40.2 MB,击败了72.58% 的Java用户
    class MinStack {
        ArrayDeque<Integer> stack1;
        ArrayDeque<Integer> stack2;

        public MinStack() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || stack2.peek() >= x) {  //stack2为单调栈，栈顶元素即为最小值
                stack2.push(x);
            }
        }

        public void pop() {
            int num = stack1.pop();
            if (stack2.peek() == num) { //当前出栈元素为最小值
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }

    //class MinStack {
    //    ArrayDeque<Integer> stack;
    //
    //    public MinStack() {
    //        stack = new ArrayDeque<>();
    //    }
    //
    //    public void push(int x) {
    //        stack.push(x);
    //        if (stack.peekLast() == null || stack.peekLast() >= x) {
    //            stack.offerLast(x);
    //        }
    //    }
    //
    //    public void pop() {
    //        int num = stack.pop();
    //        if (stack.peekLast() == num) {
    //            stack.pollLast();
    //        }
    //    }
    //
    //    public int top() {
    //        return stack.peek();
    //    }
    //
    //    public int min() {
    //        return stack.peekLast();
    //    }
    //}

    //执行耗时:18 ms,击败了56.18% 的Java用户 内存消耗:39.7 MB,击败了98.80% 的Java用户
    //class MinStack {
    //    ArrayDeque<Integer> stack;
    //    PriorityQueue<Integer> heap;
    //
    //    public MinStack() {
    //        stack = new ArrayDeque<>();
    //        heap = new PriorityQueue<>();
    //    }
    //
    //    public void push(int x) {
    //        stack.push(x);
    //        heap.offer(x);
    //    }
    //
    //    public void pop() {
    //        int x = stack.pop();
    //        heap.remove(x);
    //    }
    //
    //    public int top() {
    //        return stack.peek();
    //    }
    //
    //    public int min() {
    //        return heap.peek();
    //    }
    //}

    //执行耗时:19 ms,击败了28.24% 的Java用户 内存消耗:41.7 MB,击败了5.09% 的Java用户
    //class MinStack {
    //    int[] nums;
    //    int index = 0;
    //    PriorityQueue<Integer> heap;  //小顶堆
    //
    //    public MinStack() {
    //        nums = new int[20010];
    //        heap = new PriorityQueue<>();
    //    }
    //
    //    public void push(int x) {
    //        nums[index++] = x;
    //        heap.offer(x);
    //    }
    //
    //    public void pop() {
    //        heap.remove(nums[index - 1]);
    //        index--;
    //    }
    //
    //    public int top() {
    //        return nums[index - 1];
    //    }
    //
    //    public int min() {
    //        return heap.peek();
    //    }
    //}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}