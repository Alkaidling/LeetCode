package leetcode.editor.cn;

import java.util.ArrayDeque;

//173、二叉搜索树迭代器
class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator bSTIterator = new BinarySearchTreeIterator().new BSTIterator(root);

        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class BSTIterator {
        private TreeNode root;
        private BSTIterator bstIterator;
        private ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            this.root = root;
        }

        public int next() {
            if (bstIterator == null) {
                bstIterator = new BSTIterator(root);
            } else {
                if (root.right != null) {
                    root = root.right;
                    while (root.left != null) {
                        stack.push(root);
                        root = root.left;
                    }
                } else {
                    root = stack.pop();
                }
            }
            return root.val;
        }

        public boolean hasNext() {
            if (bstIterator == null) {
                return true;
            }
            return root.right != null || !stack.isEmpty();
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
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