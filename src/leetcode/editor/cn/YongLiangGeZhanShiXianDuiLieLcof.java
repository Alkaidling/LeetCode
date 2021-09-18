package leetcode.editor.cn;

import java.util.Stack;

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
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if (stack2.isEmpty() && !stack1.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else if(!stack2.isEmpty()){
            return stack2.pop();
        }
        return -1;
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