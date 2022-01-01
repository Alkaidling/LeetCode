package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 052、展平二叉搜索树
class NYBBNL {
    public static void main(String[] args) {
        Solution solution = new NYBBNL().new Solution();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(4,new TreeNode(3),null));
        solution.increasingBST(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        TreeNode pre;
        public TreeNode increasingBST(TreeNode root) {
            this.pre = new TreeNode(-1);
            TreeNode res = pre;
            dfs(root);
            return res.right;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            root.left = null;
            pre.right = root;
            pre = root;
            dfs(root.right);
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