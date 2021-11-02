package leetcode.editor.cn;

//237、删除链表中的节点
class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInALinkedList().new Solution();
        ListNode head1 = new ListNode(4);
        ListNode head2 = new ListNode(5);
        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(9);
        head1.next = head2; head2.next = head3; head3.next = head4;
        solution.deleteNode(head2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}