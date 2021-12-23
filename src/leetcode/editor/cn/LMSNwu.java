package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 025、链表中的两数相加
class LMSNwu {
    public static void main(String[] args) {
        Solution solution = new LMSNwu().new Solution();
        //ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);
            ListNode node = new ListNode(-1);
            ListNode tail = node;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int x = 0, y = 0;
                if (l1 != null) {
                    x = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    y = l2.val;
                    l2 = l2.next;
                }
                int sum = (x + y + carry) % 10;
                carry = (x + y + carry) / 10;
                node.next = new ListNode(sum);
                node = node.next;
            }
            return reverse(tail.next);
        }
        public ListNode reverse(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ArrayDeque<Integer> stack1 = new ArrayDeque<>();
            ArrayDeque<Integer> stack2 = new ArrayDeque<>();
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode res = null;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
                int x = 0, y = 0;
                if (!stack1.isEmpty()) {
                    x = stack1.pop();
                }
                if (!stack2.isEmpty()) {
                    y = stack2.pop();
                }
                int sum = (x + y + carry) % 10;
                carry = (x + y + carry) / 10;
                ListNode node = new ListNode(sum);
                node.next = res;
                res = node;
            }
            return res;
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