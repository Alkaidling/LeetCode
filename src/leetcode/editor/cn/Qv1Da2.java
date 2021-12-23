package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 028、展平多级双向链表
class Qv1Da2 {
    public static void main(String[] args) {
        Solution solution = new Qv1Da2().new Solution();
        Node head = new Node(1,null,null,new Node(2,null,null,new Node(3)));
        solution.flatten(head);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node flatten(Node head) {
            dfs(head);
            return head;
        }
        //dfs返回的是最后一个节点
        public Node dfs(Node head){
            if (head == null || (head.next == null && head.child == null)) {
                return head;
            }
            if (head.child != null) {
                Node temp = head.next;
                Node tail = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (tail != null) {
                    tail.next = temp;
                }
                if (temp != null) {
                    temp.prev = tail;
                    return dfs(temp);
                }else {
                    return tail;
                }
            }else {
                return dfs(head.next);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }
}