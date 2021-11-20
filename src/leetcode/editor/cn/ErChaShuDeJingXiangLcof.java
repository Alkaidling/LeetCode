package leetcode.editor.cn;

//剑指 Offer 27、二叉树的镜像
class ErChaShuDeJingXiangLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        //TreeNode right = new TreeNode(2);
        root.left = left;
        //root.right = right;
        solution.mirrorTree(root);
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
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = mirrorTree(root.left);
            TreeNode right = mirrorTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }

        //执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:35.9 MB,击败了29.03% 的Java用户
        public TreeNode mirrorTree0(TreeNode root) {
            reverseTree(root);
            return root;
        }
        public void reverseTree(TreeNode root){
            if (root == null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            reverseTree(root.left);
            reverseTree(root.right);
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