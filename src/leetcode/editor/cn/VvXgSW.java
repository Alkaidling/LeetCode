package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 078、合并排序链表
class VvXgSW {
    public static void main(String[] args) {
        Solution solution = new VvXgSW().new Solution();
        //[[-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]]
        ListNode head1 = new ListNode(-10, new ListNode(-9, new ListNode(-9, new ListNode(-3, new ListNode(-1, new ListNode(-1, new ListNode(0)))))));
        ListNode head2 = new ListNode(-5, new ListNode(4));
        ListNode head3 = new ListNode(-8);
        ListNode head4 = new ListNode(-9, new ListNode(-6, new ListNode(-5, new ListNode(-4, new ListNode(-2, new ListNode(2, new ListNode(3)))))));
        ListNode head5 = new ListNode(-3, new ListNode(-3, new ListNode(-2, new ListNode(-1, new ListNode(0)))));
        ListNode listNode = solution.mergeKLists0(new ListNode[]{head1, head2, head3, null, head4, head5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        class Node {
            int val;
            ListNode listNode;

            public Node(int val, ListNode node) {
                this.val = val;
                this.listNode = node;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(new Node(node.val, node));
                }
            }
            ListNode pre = new ListNode(-1);
            ListNode t = pre;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                t.next = node.listNode;
                t = t.next;
                if (node.listNode.next != null) {
                    queue.offer(new Node(node.listNode.next.val,node.listNode.next));
                }
            }
            return pre.next;
        }

        public ListNode mergeKLists0(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;
            ListNode l1 = merge(lists, left, mid);
            ListNode l2 = merge(lists, mid + 1, right);
            return mergeTwoLists(l1, l2);
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
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