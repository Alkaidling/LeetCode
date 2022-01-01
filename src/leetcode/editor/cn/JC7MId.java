package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 051、节点之和最大的路径
class JC7MId {
    public static void main(String[] args) {
        Solution solution = new JC7MId().new Solution();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        solution.maxPathSum(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }
        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(dfs(root.left),0);
            int right = Math.max(dfs(root.right),0);
            max = Math.max(max,root.val + left + right);
            return root.val + Math.max(left,right);
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