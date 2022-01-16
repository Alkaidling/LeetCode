package leetcode.editor.cn;

import java.util.*;

//382、链表随机节点
class LinkedListRandomNode {
    public static void main(String[] args) {
        Solution solution = new LinkedListRandomNode().new Solution(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        List<Integer> list = new ArrayList<>();

        public Solution(ListNode head) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            Random random = new Random();
            int i = random.nextInt(list.size());
            return list.get(i);
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