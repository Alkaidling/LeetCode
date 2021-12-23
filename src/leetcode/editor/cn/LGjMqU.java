package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 026、重排链表
class LGjMqU {
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))));
        solution.reorderList(l1);
        while (l1 != null) {
            System.out.print(l1.val + ",");
            l1 = l1.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public void reorderList(ListNode head) {
            //1.寻找链表中间节点
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode nextHead = slow.next;  //nextHead为后半段的链表头
            slow.next = null;

            //2.反转链表
            ListNode cur = nextHead;
            ListNode pre = null;  //反转后为链表头
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            //3.链表合并
            while (head != null && pre != null) {
                ListNode next1 = head.next;
                ListNode next2 = pre.next;
                head.next = pre;
                pre.next = next1;
                head = next1;
                pre = next2;
            }
        }

        public void reorderList_0(ListNode head) {
            ArrayDeque<ListNode> deque = new ArrayDeque<>();
            while (head != null) {
                deque.offer(head);
                head = head.next;
            }
            head = deque.pollFirst();
            while (!deque.isEmpty()) {
                head.next = deque.pollLast();
                head = head.next;
                head.next = deque.pollFirst();
                head = head.next;
            }
            if (head != null) {
                head.next = null;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}