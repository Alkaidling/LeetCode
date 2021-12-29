package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 045、二叉树最底层最左边的值
class LwUNpT {
    public static void main(String[] args) {
        Solution solution = new LwUNpT().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int res = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (i == 0) {
                        res = node.val;
                    }
                }
            }
            return res;
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