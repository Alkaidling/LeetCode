package leetcode.editor.cn;

import java.util.*;

//148、排序链表
class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4,new ListNode(0)))));
        ListNode listNode = solution.sortList(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode sortList(ListNode head) {
            ListNode t = head;
            int cnt = 0;
            while (t != null) {
                t = t.next;
                cnt++;
            }
            return mergeSort(head, cnt - 1);
        }

        public ListNode mergeSort(ListNode head, int count) {
            if (count <= 0 || head == null) {
                return head;
            }
            int cnt = 1;
            ListNode nextHead = head;
            for (int i = 0; i < count / 2; i++) {
                nextHead = nextHead.next;
                cnt++;
            }
            ListNode pre = nextHead;
            nextHead = nextHead.next;
            pre.next = null;
            ListNode sortHead1 = mergeSort(head,count / 2);
            ListNode sortHead2 = mergeSort(nextHead, count - cnt);
            ListNode newHead = new ListNode(-1);
            ListNode t = newHead;
            while (sortHead1 != null && sortHead2 != null) {
                if (sortHead1.val <= sortHead2.val) {
                    t.next = sortHead1;
                    sortHead1 = sortHead1.next;
                }else {
                    t.next = sortHead2;
                    sortHead2 = sortHead2.next;
                }
                t = t.next;
            }
            if (sortHead1 != null) {
                t.next = sortHead1;
            }
            if (sortHead2 != null) {
                t.next = sortHead2;
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