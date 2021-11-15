package leetcode.editor.cn;

//剑指 Offer 35、复杂链表的复制
class FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;
        Node node = solution.copyRandomList(n0);
        while (node != null) {
            int random = -1;
            if(node.random != null){
                random = node.random.val;
            }
            System.out.println(node.val + "," +  random);
            node = node.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node res = head;
            Node temp = res;
            while (temp != null) {
                Node t = new Node(temp.val);
                t.next = temp.next;
                temp.next = t;
                temp = t.next;
            }
            temp = res;
            while (temp != null) {
                temp.next.random = temp.random == null ? null : temp.random.next;
                temp = temp.next.next;
            }
            Node newHead = res.next;
            temp = res;
            while (temp != null) {
                Node t = temp.next;
                temp.next = temp.next.next;
                t.next = t.next == null ? null : t.next.next;
                temp = temp.next;
            }
            return newHead;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}