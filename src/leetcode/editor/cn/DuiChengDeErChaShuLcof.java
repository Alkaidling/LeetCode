package leetcode.editor.cn;

//剑指 Offer 28、对称的二叉树
class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right; root.left = left;
        boolean symmetric = solution.isSymmetric(root);
        System.out.println(symmetric);
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

        //执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:36.2 MB,击败了81.68% 的Java用户
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return dfs(root.left,root.right);
        }
        //判断left树是否等于right树
        public boolean dfs(TreeNode left,TreeNode right){
            if ((left == null && right != null) || (left != null && right == null)) {
                return false;
            } else if (left == null && right == null) {
                return true;
            }else {
                return left.val == right.val && dfs(left.left,right.right) && dfs(left.right,right.left);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}