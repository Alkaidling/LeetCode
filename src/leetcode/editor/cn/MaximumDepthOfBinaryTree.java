package leetcode.editor.cn;


//104、二叉树的最大深度
class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        //TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode root = null;
        int i = solution.maxDepth(root);
        System.out.println(i);
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
    class Solution {

        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
        }

        public int maxDepth0(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return dfs(root, 1);
        }

        public int dfs(TreeNode root, int deep) {
            if (root.left == null && root.right == null) {
                return deep;
            } else if (root.left != null && root.right == null) {
                return dfs(root.left, deep + 1);
            } else if (root.left == null && root.right != null) {
                return dfs(root.right, deep + 1);
            } else {
                return Math.max(dfs(root.right, deep + 1), dfs(root.left, deep + 1));
            }
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