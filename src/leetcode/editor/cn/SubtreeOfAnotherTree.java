package leetcode.editor.cn;

import java.util.*;

//572、另一棵树的子树
class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        TreeNode r1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode sb = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSubtree(r1, sb));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null){
                return false;
            }
            boolean b = false;
            if(root.val == subRoot.val){
                b = dfs(root,subRoot);
            }
            return b || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        public boolean dfs(TreeNode root, TreeNode subRoot){
            if(root == null){
                return subRoot == null;
            }
            if(subRoot == null){
                return false;
            }
            if(root.val == subRoot.val){
                return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
            }
            return false;
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