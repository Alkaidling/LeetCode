package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.*;

//98、验证二叉搜索树
class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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

        //中序非递归
        public boolean isValidBST(TreeNode root) {
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            long pre = Long.MIN_VALUE;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(root.val <= pre){
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
            return true;
        }

        //中序递归
        long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值
        public boolean isValidBST2(TreeNode root) {
            return inorder(root);
        }
        // 中序遍历
        private boolean inorder(TreeNode node) {
            if(node == null) return true;
            boolean l = inorder(node.left);
            if(node.val <= pre) {
                return false;
            }
            pre = node.val;
            boolean r = inorder(node.right);
            return l && r;
        }

        public boolean isValidBST1(TreeNode root) {
            return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        public boolean dfs(TreeNode root,long min, long max){
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
        }

        List<Integer> list;
        public boolean isValidBST0(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) <= list.get(i - 1)){
                    return false;
                }
            }
            return true;
        }
        public void dfs(TreeNode root){
            if (root == null) {
                return;
            }
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
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