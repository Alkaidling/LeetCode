package leetcode.editor.cn;


//19、删除链表的倒数第 N 个结点
class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = solution.removeNthFromEnd(head, 2);

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

        //快慢指针，一次遍历
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = head;  //快指针，遍历完成temp走到null
            ListNode curr = temp;  //慢指针，遍历完成curr走到删除节点的前一个节点
            int count = 0;  //节点个数
            while (temp != null) {
                if (count >= n+1) { //快指针走到n+1时 慢指针开始动（若为count >= n，则慢指针刚好走到被删除的位置）
                    curr = curr.next;
                }
                temp = temp.next;
                count++;
            }
            //删除的是头节点
            if (count == n) {
                return head.next;
            }
            curr.next = curr.next.next;
            return head;
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