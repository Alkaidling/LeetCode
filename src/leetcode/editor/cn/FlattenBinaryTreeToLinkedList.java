package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.*;

//114、二叉树展开为链表
class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode next = cur.left;
                    TreeNode predecessor = next;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    predecessor.right = cur.right;
                    cur.left = null;
                    cur.right = next;
                }
                cur = cur.right;  // cur -> next (cur.left)
            }
        }

        //O(1)空间复杂度
        TreeNode tail = null;
        public void flatten1(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten1(root.right);
            flatten1(root.left);
            root.right = tail;
            root.left = null;
            tail = root;
        }

        ArrayList<TreeNode> list;
        public void flatten0(TreeNode root) {
            TreeNode t = root;
            list = new ArrayList<>();
            dfs(root);
            for (int i = 1; i < list.size(); i++) {
                t.right = list.get(i);
                t.left = null;
                t = list.get(i);
            }
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root);
            dfs(root.left);
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