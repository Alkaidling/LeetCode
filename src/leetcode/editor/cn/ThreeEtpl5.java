package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 049、从根节点到叶节点的路径数字之和
class ThreeEtpl5 {
    public static void main(String[] args) {
        Solution solution = new ThreeEtpl5().new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(9,null, new TreeNode(1)), new TreeNode(0));
        System.out.println(solution.sumNumbers(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }
        public int dfs(TreeNode root,int val){
            if (root == null) {
                return 0;
            }
            val = val * 10 + root.val;
            if (root.left == null && root.right == null) {
                return val;
            }
            return dfs(root.left,val) + dfs(root.right,val);
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