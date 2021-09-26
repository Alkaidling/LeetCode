package leetcode.editor.cn;
//2、两数相加
class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(5,new ListNode(4));
        ListNode l2 = new ListNode(5,new ListNode(5));
        solution.addTwoNumbers(l1,l2);
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

    //非递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int len1 = 0;
        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        int len2 = 0;
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }
        ListNode big = len1 > len2 ? t1 : t2;
        ListNode small = len1 > len2 ? t2 : t1;

        ListNode res = big;

        int carry = 0;
        while (big != null) {
            if (small == null) {
                if (carry != 0) {
                    int temp = big.val;
                    big.val = (temp + carry) % 10;
                    carry = (temp + carry) / 10;
                }
                if (big.next == null) {
                    break;
                }
                big = big.next;
                continue;
            }
            int temp = big.val;
            big.val = (temp + small.val) % 10 + carry;
            carry = (temp + small.val) / 10;
            if (big.val >= 10) {
                big.val -= 10;
                carry++;
            }
            if(big.next == null && small.next == null && temp + small.val + carry >= 10 && carry != 0) {
                big.next = new ListNode(carry);
                carry = 0;
                break;
            }
            big = big.next;
            small = small.next;

        }
        if (carry != 0 && big != null) {
            big.next = new ListNode(carry);
        }

        return res;
    }


    //取出所有数再相加，超过long型最大值
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long i1 = 0;
        long i2 = 0;
        long n = 1;
        while (l1 != null) {
            long t = l1.val;
            i1 = i1 + t*n;
            n *= 10;
            l1 = l1.next;
        }
        n = 1;
        while (l2 != null) {
            long t = l2.val;
            i2 = i2 + t*n;
            n *= 10;
            l2 = l2.next;
        }
        long sum = i1 + i2;
        if (sum == 0) {
            return new ListNode(0);
        }
        ListNode list = new ListNode();
        ListNode res = list;
        while (sum != 0) {
            list.next = new ListNode((int) (sum % 10));
            sum /= 10;
            list = list.next;
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class ListNode {
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