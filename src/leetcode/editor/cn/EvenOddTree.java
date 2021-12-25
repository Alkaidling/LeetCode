package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

//1609、奇偶树
class EvenOddTree {
    public static void main(String[] args) {
        Solution solution = new EvenOddTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode pre = null;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (level % 2 == 0) {
                        if (node.val % 2 == 0) {
                            return false;
                        }
                        if (i > 0 && node.val <= pre.val) {
                            return false;
                        }
                    }
                    if (level % 2 != 0) {
                        if (node.val % 2 != 0) {
                            return false;
                        }
                        if (i > 0 && node.val >= pre.val) {
                            return false;
                        }
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    pre = node;
                }
                level++;
            }
            return true;
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