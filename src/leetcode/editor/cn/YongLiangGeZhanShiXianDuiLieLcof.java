package leetcode.editor.cn;

import java.util.ArrayDeque;

//Java：剑指 Offer 09、用两个栈实现队列
class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        CQueue cQueue = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
        cQueue.appendTail(3);
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        int i = cQueue.deleteHead();
        System.out.println(i);
        int i1 = cQueue.deleteHead();
        System.out.println(i1);
        int i2 = cQueue.deleteHead();
        System.out.println(i2);
        int i3 = cQueue.deleteHead();
        System.out.println(i3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {

        private ArrayDeque<Integer> stack1;
        private ArrayDeque<Integer> stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            //从栈1进
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            //从栈2出
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}