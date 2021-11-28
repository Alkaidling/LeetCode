package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;

//剑指 Offer 54、二叉搜索树的第k大节点
class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
        int res,k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        public void dfs(TreeNode root){
            if (root == null) {
                return;
            }
            dfs(root.right);
            k--;
            if (k == 0) {
                res = root.val;
                return;
            }
            dfs(root.left);
        }

        //执行耗时:1 ms,击败了32.10% 的Java用户 内存消耗:39.4 MB,击败了5.07% 的Java用户
        public int kthLargest0(TreeNode root, int k) {
            LinkedList<Integer> list = new LinkedList<>();
            dfs(root,list);
            return list.get(list.size()-k);
        }
        public void dfs(TreeNode root, LinkedList<Integer> queue){
            if (root == null) {
                return;
            }
            dfs(root.left,queue);
            queue.add(root.val);
            dfs(root.right,queue);
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