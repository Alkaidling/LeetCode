package leetcode.editor.cn;

//剑指 Offer 55 - II、平衡二叉树
class PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }
        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }else {
                return Math.max(leftHeight,rightHeight) + 1;
            }
        }

        public boolean isBalanced0(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(maxDepth(root.right) - maxDepth(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}