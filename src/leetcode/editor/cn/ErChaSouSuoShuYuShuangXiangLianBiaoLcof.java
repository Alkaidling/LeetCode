package leetcode.editor.cn;

import java.util.ArrayDeque;

//剑指 Offer 36、二叉搜索树与双向链表
class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //不存储，直接修改指针
        Node head,pre;
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            head.left = pre; //此时pre指向中序遍历最后一个节点
            pre.right = head;
            return head;

        }
        public void dfs(Node root){
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre != null) {
                pre.right = root;
            }else {
                head = root;
            }
            root.left = pre;
            pre = root;
            dfs(root.right);
        }

        //栈存储中序遍历
        public Node treeToDoublyList0(Node root) {
            if (root == null) {
                return null;
            }
            ArrayDeque<Node> stack = new ArrayDeque<>();
            dfs(root,stack);
            Node head = stack.pop();
            Node temp = head;
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                temp.right = node;
                node.left = temp;
                temp = node;
            }
            head.left = temp;
            temp.right = head;
            return head;
        }

        public void dfs(Node root,ArrayDeque<Node> stack){
            if (root == null) {
                return;
            }
            dfs(root.left,stack);
            stack.offer(root);
            dfs(root.right,stack);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}