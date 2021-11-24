package leetcode.editor.cn;

//Java：剑指 Offer 22、链表中倒数第k个节点
class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = solution.getKthFromEnd(a, 2);
        System.out.println(listNode.val + "->" + listNode.next.val);
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
        public ListNode getKthFromEnd(ListNode head, int k) {
            int count = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                count++;
            }
            temp = head;
            for (int i = 0; i < count - k; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public ListNode getKthFromEnd0(ListNode head, int k) {
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
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

