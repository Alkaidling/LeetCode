package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Java：剑指 Offer 06、从尾到头打印链表
class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode l1 = new CongWeiDaoTouDaYinLianBiaoLcof().new ListNode(1);
        ListNode l2 = new CongWeiDaoTouDaYinLianBiaoLcof().new ListNode(3);
        ListNode l3 = new CongWeiDaoTouDaYinLianBiaoLcof().new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        int[] ints = solution.reversePrint(l1);
        System.out.println(Arrays.toString(ints));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //栈存储实现倒叙
    public int[] reversePrint1(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int[] ints = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            ints[i] = stack.pop().val;
        }
        return ints;
    }


    //从后往前向数组中填入值
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int i=0;
        ListNode temp = head;
        while (temp != null) {
            ++i;
            temp = temp.next;
        }
        int[] res = new int[i];
        for (int j = res.length - 1; j >= 0; j--) {
            res[j] = head.val;
            head = head.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
}