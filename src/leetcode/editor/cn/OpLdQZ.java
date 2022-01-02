package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 056、二叉搜索树中两个节点之和
class OpLdQZ {
    public static void main(String[] args) {
        Solution solution = new OpLdQZ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            return dfs(root, k, set);
        }

        public boolean dfs(TreeNode root, int k, Set<Integer> set) {
            if (root == null) {
                return false;
            }
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            return dfs(root.left, k, set) || dfs(root.right, k, set);
        }

        public boolean findTarget1(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return false;
        }

        Set<Integer> set;
        boolean flag = false;
        boolean res = false;

        public boolean findTarget0(TreeNode root, int k) {
            set = new HashSet<>();
            dfs(root, k);
            flag = true;
            dfs(root, k);
            return res;
        }

        public void dfs(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            dfs(root.left, k);
            if (flag) {
                if (set.contains(k - root.val) && root.val != k - root.val) {
                    res = true;
                }
            } else {
                set.add(root.val);
            }
            dfs(root.right, k);
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