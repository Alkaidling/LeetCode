package leetcode.editor.cn;

import java.util.*;

//230、二叉搜索树中第K小的元素
class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
        TreeNode root = new TreeNode(3,new TreeNode(1,null,new TreeNode(2)),new TreeNode(4));
        int i = solution.kthSmallest(root, 4);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        //TODO
        // O(N)
        public int kthSmallest(TreeNode root, int k) {
            return root.val;
        }

        //中序遍历  O(H+k)
        public int kthSmallest1(TreeNode root, int k) {
            TreeNode node = root;
            Deque<TreeNode> stack = new ArrayDeque<>();
            int num = 0;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                num++;
                if (num == k) {
                    return node.val;
                }
                node = node.right;
            }
            return node.val;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
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