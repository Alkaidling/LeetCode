package leetcode.editor.cn;
//Java：725、分隔链表
class SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode[] listNodes = solution.splitListToParts1(head, 5);
        for (ListNode listNode : listNodes) {
            while (listNode != null) {
                System.out.print(listNode.val + " ");
                listNode = listNode.next;
            }
            System.out.println();
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next; //记录下一个节点
            curr.next = null; //当前部分的到curr节点截至
            curr = next;  //下一个节点为下个部分的首节点
        }
        return parts;
    }


    public ListNode[] splitListToParts1(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        ListNode[] res = new ListNode[k];
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if(len <= k){
            for (int i = 0; i < k; i++) {
                if(head == null){
                    continue;
                }
                res[i] = head;
                head = head.next;
            }
            for (int i = 0; i < k; i++) {
                if (res[i] != null && res[i].next != null) {
                    res[i].next = null;
                }
            }
        } else if (len > k) {
            int pre = len / k;  //每个部分的长度
            int mod = len % k;  //余数长度，加到前面的节点
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    continue;
                }
                res[i] = head;
                for (int j = 1; j < pre; j++) {
                    head = head.next;
                }
                if (mod > 0) { //每次-1，直到余数为0
                    head = head.next;
                    mod--;
                }
                head = head.next;
            }
            mod = len % k;
            for (int i = 0; i < k; i++) {
                temp = res[i];
                if (res[i] != null && res[i].next != null) {
                    for (int j = 1; j < pre; j++) {
                        temp = temp.next;
                    }
                    if (mod > 0) {
                        temp = temp.next;
                        mod--;
                    }
                    temp.next = null;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

}
}