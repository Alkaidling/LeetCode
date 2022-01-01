package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 055、二叉搜索树迭代器
class KTOapQ {
    public static void main(String[] args) {
        BSTIterator bstIterator = new KTOapQ().new BSTIterator(new TreeNode(7,new TreeNode(3),new TreeNode(15,new TreeNode(9),new TreeNode(20))));
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class BSTIterator {
        Deque<TreeNode> stack;
        TreeNode cur;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new ArrayDeque<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int res = cur.val;
            cur = cur.right;
            return res;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}