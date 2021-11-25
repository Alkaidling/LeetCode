package leetcode.editor.cn;

import java.util.HashSet;

//剑指 Offer 52、两个链表的第一个公共节点
class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        //你变成我，走过我走过的路。
        //我变成你，走过你走过的路。
        //然后我们便相遇了..
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA;
            ListNode pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }

        //执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:41 MB,击败了72.03% 的Java用户
        //O(n) O(1)
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            int count = 0;
            ListNode A = headA;
            ListNode B = headB;
            while (A != null) {
                A = A.next;
                count++;
            }
            while (B != null) {
                B = B.next;
                count--;
            }
            if(count < 0){
                return getIntersectionNode(headB,headA);
            }
            while (count-- > 0 && headA != null){
                headA = headA.next;
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }

        //执行耗时:8 ms,击败了10.85% 的Java用户 内存消耗:42.4 MB,击败了5.04% 的Java用户
        //O(n) O(n)
        public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}