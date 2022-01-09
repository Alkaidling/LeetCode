package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 077、链表排序
class SevenWHec2 {
    public static void main(String[] args) {
        Solution solution = new SevenWHec2().new Solution();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode listNode = solution.sortList(head);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }
            ListNode dummyHead = new ListNode(0, head);
            for (int subLength = 1; subLength < length; subLength <<= 1) {
                //subLength为每次归并链表的长度
                ListNode prev = dummyHead, curr = dummyHead.next;
                while (curr != null) {
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;  //截断头尾head1的链表
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;  //next为剩下的链表
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;  //截断头尾head2的链表
                    }
                    ListNode merged = merge(head1, head2);  //归并
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;  //循环剩下的链表
                }
            }
            return dummyHead.next;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }


        public ListNode sortList0(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode t = slow;
            //截取链表，slow为后半段链表的头
            slow = slow.next;
            t.next = null;
            ListNode sortedHead1 = sortList(head);
            ListNode sortedHead2 = sortList(slow);
            ListNode newHead = new ListNode(-1);
            t = newHead;
            while (sortedHead1 != null && sortedHead2 != null) {
                if (sortedHead1.val <= sortedHead2.val) {
                    t.next = sortedHead1;
                    sortedHead1 = sortedHead1.next;
                } else {
                    t.next = sortedHead2;
                    sortedHead2 = sortedHead2.next;
                }
                t = t.next;
            }
            if (sortedHead1 != null) {
                t.next = sortedHead1;
            }
            if (sortedHead2 != null) {
                t.next = sortedHead2;
            }
            return newHead.next;
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