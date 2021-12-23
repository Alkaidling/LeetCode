package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 027、回文链表
class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode pre = null;
            ListNode cur = slow.next;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            while (pre != null) {
                if (pre.val != head.val) {
                    return false;
                }
                pre = pre.next;
                head = head.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}