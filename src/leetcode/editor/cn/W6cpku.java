package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 054、所有大于等于节点的值之和
class W6cpku {
    public static void main(String[] args) {
        Solution solution = new W6cpku().new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        TreeNode treeNode = solution.convertBST(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode convertBST(TreeNode root) {
            dfs(root, 0);
            return root;
        }

        private int dfs(TreeNode root, int parentVal) {
            if (root == null)
                return parentVal;
            root.val += dfs(root.right, parentVal);
            return dfs(root.left, root.val);
        }


        int sum = 0;
        public TreeNode convertBST0(TreeNode root) {
            dfs(root);
            return root;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.right);
            sum += root.val;
            root.val = sum;
            dfs(root.left);
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