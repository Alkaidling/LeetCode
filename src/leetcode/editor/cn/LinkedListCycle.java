package leetcode.editor.cn;

import java.util.*;

//141、环形链表
class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public boolean hasCycle(ListNode head) {
            int n = 0;
            while (head != null) {
                head = head.next;
                n++;
                if (n > 1e4) {
                    return true;
                }
            }
            return false;
        }
        public boolean hasCycle0(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}