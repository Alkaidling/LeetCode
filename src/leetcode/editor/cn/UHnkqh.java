package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 024、反转链表
class UHnkqh {
    public static void main(String[] args) {
        Solution solution = new UHnkqh().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        //递归
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
        //迭代
        public ListNode reverseList_0(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                //ListNode t = cur;
                //cur = cur.next;
                //t.next = pre;
                //pre = t;
            }
            return pre;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
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