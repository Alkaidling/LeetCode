package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer 32 - III、从上到下打印二叉树 III
class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            ArrayList<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            int level = 1;
            queue.offer(root);
            while (!queue.isEmpty()) {
                LinkedList<Integer> temp = new LinkedList<>();
                int n = queue.size();  //当前队列中n个元素均为树的同一层
                for (int i = n; i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (level % 2 != 0) {
                        temp.addLast(node.val);   //奇数层尾插法（正序）
                    }else {
                        temp.addFirst(node.val);  //偶数层头插法（倒序）
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                lists.add(temp);
                level++;
            }
            return lists;
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