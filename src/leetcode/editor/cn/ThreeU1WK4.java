package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 023、两个链表的第一个重合节点
class ThreeU1WK4 {
    public static void main(String[] args) {
        Solution solution = new ThreeU1WK4().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }

        public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
            int m = 0;
            ListNode t = headA;
            while (t != null) {
                t = t.next;
                m++;
            }
            t = headB;
            while (t != null) {
                t = t.next;
                m--;
            }
            while (m > 0) {
                headA = headA.next;
                m--;
            }
            while (m < 0) {
                headB = headB.next;
                m++;
            }
            while (headA != null && headB != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}