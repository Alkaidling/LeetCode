package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 050、向下的路径节点之和
class SixEUYwP {
    public static void main(String[] args) {
        Solution solution = new SixEUYwP().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            HashMap<Long, Integer> prefix = new HashMap<>();
            prefix.put(0L,1);
            return dfs(root,prefix,0,targetSum);
        }
        public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            curr += root.val;
            res = prefix.getOrDefault(curr - targetSum,0);
            prefix.put(curr,prefix.getOrDefault(curr,0) + 1);
            res += dfs(root.left,prefix,curr,targetSum);
            res += dfs(root.right,prefix,curr,targetSum);
            prefix.put(curr,prefix.getOrDefault(curr,0) - 1);
            return res;
        }
        //public int pathSum(TreeNode root, int targetSum) {
        //    if (root == null) {
        //        return 0;
        //    }
        //    int res = dfs(root,targetSum);
        //    res += pathSum(root.left,targetSum);
        //    res += pathSum(root.right,targetSum);
        //    return res;
        //}
        //
        //public int dfs(TreeNode root, int target){
        //    if (root == null) {
        //        return 0;
        //    }
        //    int res = 0;
        //    if (root.val == target) {
        //        res++;
        //    }
        //    int left = dfs(root.left,target - root.val);
        //    int right = dfs(root.right,target - root.val);
        //    return res + left + right;
        //}
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