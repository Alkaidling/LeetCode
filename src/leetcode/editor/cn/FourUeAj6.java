package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 029、排序的循环链表
class FourUeAj6 {
    public static void main(String[] args) {
        Solution solution = new FourUeAj6().new Solution();
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Node insert = solution.insert(node1, 0);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        boolean flag = false;

        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node t = new Node(insertVal);
                t.next = t;
                return t;
            }
            if (head.next == head) {
                Node t = new Node(insertVal);
                t.next = head;
                head.next = t;
                return head;
            }
            if (head.val <= insertVal && head.next.val >= insertVal) {
                Node t = new Node(insertVal);
                t.next = head.next;
                head.next = t;
            } else {
                dfs(head, head.next, insertVal);
                if (!flag) {
                    Node t = new Node(insertVal);
                    t.next = head.next;
                    head.next = t;
                }
            }
            return head;
        }

        public void dfs(Node visit, Node head, int insertVal) {
            if (visit == head) {
                return;
            }
            //  最大值       最小值
            if (head.val > head.next.val && (insertVal >= head.val || insertVal <= head.next.val)) {
                Node t = new Node(insertVal);
                t.next = head.next;
                head.next = t;
                flag = true;
            } else if (head.val <= insertVal && head.next.val >= insertVal) {
                Node t = new Node(insertVal);
                t.next = head.next;
                head.next = t;
                flag = true;
            } else {
                dfs(visit, head.next, insertVal);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}