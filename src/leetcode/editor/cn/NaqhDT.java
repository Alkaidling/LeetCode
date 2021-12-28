package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 043、往完全二叉树添加节点
class NaqhDT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        root = new TreeNode(1);
        CBTInserter cbtInserter = new NaqhDT().new CBTInserter(root);
        System.out.println(cbtInserter.insert(2));
        System.out.println(cbtInserter.insert(3));
        System.out.println(cbtInserter.insert(4));
        TreeNode node = cbtInserter.get_root();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class CBTInserter {
        TreeNode root;
        Deque<TreeNode> queue;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new ArrayDeque<>();
            ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
            nodes.offer(root);
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.poll();
                    if (node.left != null) {
                        nodes.offer(node.left);
                    }
                    if (node.right != null) {
                        nodes.offer(node.right);
                    }
                    if (node.left == null || node.right == null){
                        queue.offer(node);
                    }
                }
            }
        }

        public int insert(int v) {
            TreeNode node = queue.peek();
            TreeNode newNode = new TreeNode(v);
            if (node.left == null) {
                node.left = newNode;
            }else if (node.right == null) {
                node.right = newNode;
                queue.poll();
            }
            queue.offer(newNode);
            return node.val;
        }

        public TreeNode get_root() {
            return root;
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