package leetcode.editor.cn;

//剑指 Offer 18、删除链表的节点
class ShanChuLianBiaoDeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
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
        //递归
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            if (head.val == val) {
                return head.next;
            }else {
                head.next = deleteNode(head.next,val);
            }
            return head;
        }

        public ListNode deleteNode0(ListNode head, int val) {
            if (head.val == val) {
                return head.next;
            }
            ListNode temp = head;
            ListNode pre = head;
            while (temp != null) {
                if (temp.val == val) {
                    pre.next = temp.next;
                }
                pre = temp;
                temp = temp.next;
            }
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}