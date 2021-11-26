package leetcode.editor.cn;

//700、二叉搜索树中的搜索
class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
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
        //非递归
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && root.val != val) {
                root = root.val > val ? root.left : root.right;
            }
            return root;
        }

        //递归
        public TreeNode searchBST0(TreeNode root, int val) {
            if (root == null || root.val == val) {
                return root;
            }
            return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
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