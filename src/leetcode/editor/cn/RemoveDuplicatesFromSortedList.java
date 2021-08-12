package leetcode.editor.cn;
//Java：83、删除排序链表中的重复元素
class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        //head = new ListNode(1, new ListNode(1));
        head = new ListNode(1, new ListNode(1, new ListNode(1)));
        //head = new ListNode(1, new ListNode(1, new ListNode(2)));
        //head = null;
        solution.deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            if (head.next != null)
                head = head.next;
            else break;
        }

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

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null)
                return head;

            ListNode cur = head;
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            //ListNode temp = head;
            //while (temp != null){
            //    ListNode index = temp;
            //    while (index != null){
            //
            //        if (index.next != null){
            //            index = index.next;
            //            if (index.val == temp.val)
            //                continue;
            //            else{
            //                temp.next = index;
            //                break;
            //            }
            //        }
            //
            //        else {
            //            if (index.val == temp.val){
            //                temp.next = null;
            //                break;
            //            }
            //            else{
            //                temp.next = index;
            //                break;
            //            }
            //        }
            //
            //    }
            //    temp = temp.next;
            //}
            return head;
        }

        //递归
        //public ListNode deleteDuplicates(ListNode head) {
        //    //1：这种情况不可能有相同节点，直接返回
        //    if (head == null || head.next == null) {
        //        return head;
        //    }
        //    //2：当前节点与下个节点一样
        //    if (head.val == head.next.val) {
        //        //3：将当前节点的下个节点跳过，指向递下下个归后的结果
        //        head.next = deleteDuplicates(head.next.next);
        //        //4：为了防止删除了下个节点，与下下个节点还是一样，继续递归，如[1,1,1]这种情况，跳过了第二个节点，还剩下[1,1]
        //        return deleteDuplicates(head);
        //    }
        //    //5：当前节点与下个节点不一样，继续递归下个节点，递归函数继续判断是否与下下个节点一样(见2))
        //    deleteDuplicates(head.next);
        //    return head;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}