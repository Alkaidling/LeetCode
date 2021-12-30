package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 047、二叉树剪枝
class POCWxh {
    public static void main(String[] args) {
        Solution solution = new POCWxh().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.left == null && root.right == null && root.val == 0) {
                return null;
            }
            return root;
        }

        public TreeNode pruneTree0(TreeNode root) {
            TreeNode pre = new TreeNode(-1);
            pre.right = root;
            dfs(root, pre, 1);
            return pre.right;
        }

        public void dfs(TreeNode root, TreeNode pre, int v) {
            if (root == null) {
                return;
            }
            dfs(root.left, root, -1);
            dfs(root.right, root, 1);
            if (root.val == 0 && root.right == null && root.left == null) {
                if (v == -1) {
                    pre.left = null;
                } else if (v == 1) {
                    pre.right = null;
                }
            }
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