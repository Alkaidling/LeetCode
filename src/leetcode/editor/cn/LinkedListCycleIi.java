package leetcode.editor.cn;

import java.util.*;

//142、环形链表 II
class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            boolean flag = false;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow =slow.next;
                if (fast == slow) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return null;
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}