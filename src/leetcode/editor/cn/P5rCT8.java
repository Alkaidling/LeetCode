package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 053、二叉搜索树中的中序后继
class P5rCT8 {
    public static void main(String[] args) {
        Solution solution = new P5rCT8().new Solution();
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        TreeNode treeNode = solution.inorderSuccessor(root, left);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode cur = root;
            TreeNode res = null;
            while (cur != null) {
                if (cur.val > p.val) {
                    res = cur;
                    cur = cur.left;
                }else {
                    cur = cur.right;
                }
            }
            return res;
        }

        TreeNode res = null;
        public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
            dfs(root,p);
            return res;
        }

        private void dfs(TreeNode root, TreeNode p) {
            if (root == null) {
                return;
            }
            dfs(root.left,p);
            if (res == null && root.val > p.val) {
                res = root;
            }
            dfs(root.right,p);
        }


        List<TreeNode> list;

        public TreeNode inorderSuccessor0(TreeNode root, TreeNode p) {
            list = new ArrayList<>();
            dfs(root);
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1 && list.get(i) == p) {
                    return list.get(i + 1);
                }
            }
            return null;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            list.add(root);
            dfs(root.right);
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}