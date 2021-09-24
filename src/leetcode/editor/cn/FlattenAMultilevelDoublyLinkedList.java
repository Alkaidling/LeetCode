package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：430、扁平化多级双向链表
class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenAMultilevelDoublyLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
    //双向链表看作树，child即为左孩子，next即为右孩子，返回值为树的先序遍历
class Solution {

    //迭代实现
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        for (; head != null; ) {
            if (head.child == null) {
                head = head.next;
            } else {
                Node tmp = head.next; //先处理head的第一个child节点，将head.next保存
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node last = head;
                while (last.next != null) {
                    last = last.next;  //找到head.child的最后一个节点last，将head.next连到last后面
                }
                last.next = tmp;
                if (tmp != null) {
                    tmp.prev = last;
                }
                head = head.next; //继续循环，找孩子节点
            }
        }
        return dummy.next;
    }


    //递归实现
    Deque<Node> stack = new ArrayDeque<>();
    public Node flatten1(Node head) {
        dfs(head);
        return head;
    }
    public void dfs(Node head) {
        if (head != null) {
            if (head.next != null && head.child == null) {
                dfs(head.next);
            }
            if (head.child != null) {
                if (head.next != null) {
                    stack.push(head.next);
                }
                head.child.prev = head;
                head.next = head.child;
                head.child = null;
                dfs(head.next);
            }
            if (!stack.isEmpty()) {
                Node temp = stack.pop();
                head.next = temp;
                temp.prev = head;
                dfs(head.next);
            }
        }
    }

    //不借助栈实现递归操作
    Node dfs1(Node head) {
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node tmp = head.next;
                Node childLast = dfs1(head.child);  //childLast为扁平化最后一个节点，并将head.next连到它后面
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childLast != null) {
                    childLast.next = tmp;
                }
                if (tmp != null) {
                    tmp.prev = childLast;
                }
                last = head;
                head = childLast;
            }
        }
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Node{
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
}