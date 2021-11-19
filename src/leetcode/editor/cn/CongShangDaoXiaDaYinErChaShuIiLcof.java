package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer 32 - II、从上到下打印二叉树 II
class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        root.left = root1; root.right = root2; root1.left = root3; root1.right = root4;
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
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
            queue.offer(root);
            while (!queue.isEmpty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                int n = queue.size();  //当前队列中n个元素均为树的同一层
                for (int i = n; i > 0; i--) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                lists.add(temp);
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