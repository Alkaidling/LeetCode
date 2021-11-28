package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 34、二叉树中和为某一值的路径
class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(1));
        List<List<Integer>> lists = solution.pathSum(root, -5);
        System.out.println(lists);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            dfs(root, target, 0, lists, list);
            return lists;
        }

        private void dfs(TreeNode root, int target, int sum, ArrayList<List<Integer>> lists, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
            sum += root.val;
            list.add(root.val);
            if (root.right == null && root.left == null && target == sum) {
                lists.add(new ArrayList<>(list));
            }
            dfs(root.left, target, sum, lists, list);
            dfs(root.right, target, sum, lists, list);
            list.remove(list.size()-1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
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