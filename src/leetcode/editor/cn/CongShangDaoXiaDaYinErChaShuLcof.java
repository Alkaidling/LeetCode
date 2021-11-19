package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;

//剑指 Offer 32 - I、从上到下打印二叉树
class CongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
        //BFS
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            int n = list.size();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = list.get(i);
            }
            return nums;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}