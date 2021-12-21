package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 021、删除链表的倒数第 n 个结点
class SLwz0R {
    public static void main(String[] args) {
        Solution solution = new SLwz0R().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode t = new ListNode(0);
            t.next = head;
            ListNode first = head;
            ListNode second = t;
            int firstStep = 0;
            while (first != null) {
                if (firstStep >= n) {
                    second = second.next;
                }
                first = first.next;
                firstStep++;
            }
            second.next = second.next.next;
            return t.next;
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