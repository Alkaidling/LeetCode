package leetcode.editor.cn;

import java.util.*;

//337、打家劫舍 III
class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        System.out.println(solution.rob(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(TreeNode root) {
            int[] r = d(root);
            return Math.max(r[0],r[1]);
        }
        public int[] d(TreeNode root) {
            if (root == null) {
                return new int[]{0,0};
            }
            int[] left = d(root.left);
            int[] right = d(root.right);
            int addRoot = root.val + left[1] + right[1];
            int notAddRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return new int[]{addRoot,notAddRoot};
        }

        HashMap<TreeNode,Integer> map1;  // 选root的最大值
        HashMap<TreeNode,Integer> map2;  // 不选root的最大值
        public int rob1(TreeNode root) {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            dfs(root);
            return Math.max(map2.getOrDefault(root,0),map1.getOrDefault(root,0));
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            map1.put(root, root.val + map2.getOrDefault(root.left,0) + map2.getOrDefault(root.right,0));
            map2.put(root,Math.max(map1.getOrDefault(root.left,0),map2.getOrDefault(root.left, 0)) + Math.max(map1.getOrDefault(root.right,0), map2.getOrDefault(root.right, 0)));
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