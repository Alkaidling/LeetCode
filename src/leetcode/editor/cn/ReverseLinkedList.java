package leetcode.editor.cn;

//206、反转链表
class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        solution.reverseList(head);
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
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }
            return pre;
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