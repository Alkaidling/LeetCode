package leetcode.editor.cn;
//Java：合并两个有序链表
class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode a1,a2,l1;
        a1 = new ListNode(8);
        a2 = new ListNode(6,a1);
        l1 = new ListNode(1,a2);

        ListNode b1,b2,l2,b3,b4;
        b4 = new ListNode(9);
        b3 = new ListNode(5,b4);
        b1 = new ListNode(4,b3);
        b2 = new ListNode(3,b1);
        l2 = new ListNode(1,b2);

        System.out.println(l1.val+","+l1.next.val+","+l1.next.next.val);
        System.out.println(l2.val+","+l2.next.val+","+l2.next.next.val);

        ListNode mergeLists = solution.mergeTwoLists(l1, l2);
        ListNode temp = mergeLists;
        System.out.println(temp.val);
        while (true) {
            if (temp.next!=null){
                temp = temp.next;
                System.out.println(temp.val);
            }
            else
                break;
        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //非递归实现
        ListNode head = new ListNode(0);
        ListNode first = head;
        while (l1!=null && l2!=null){
            if(l1.val > l2.val){
                first.next = l2;
                first = first.next;
                l2 = l2.next;
            }else {
                first.next = l1;
                first = first.next;
                l1 = l1.next;
            }
        }
        if(l1 != null){
            first.next = l1;
        }
        if(l2 != null){
            first.next = l2;
        }
        return head.next;
    }
    //递归实现
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode res;
        if(l1.val<l2.val){
            res = l1;
            res.next = mergeTwoLists1(l1.next,l2);
        }else {
            res = l2;
            res.next = mergeTwoLists1(l1,l2.next);
        }
        return res;
    }
    //新建链表非递归实现
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                newHead.val=l1.val;
                l1 = l1.next;
                newHead.next=new ListNode();
                newHead = newHead.next;
            }else {
                newHead.val=l2.val;
                l2 = l2.next;
                newHead.next=new ListNode();
                newHead = newHead.next;
            }
        }
        //一个链表指针到最后为null，这时旨在还指在另一个链表的最大的值（也是两个链表的最大值）上
        if(l1 != null){
            newHead.val = l1.val;
        }
        if(l2 != null){
            newHead.val = l2.val;
        }
        return temp;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
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

}