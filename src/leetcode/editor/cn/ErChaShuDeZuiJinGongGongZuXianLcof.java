package leetcode.editor.cn;

import java.util.ArrayDeque;

//剑指 Offer 68 - II、二叉树的最近公共祖先
class ErChaShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
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

        //执行耗时:7 ms,击败了75.46% 的Java用户 内存消耗:39.9 MB,击败了18.36% 的Java用户
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == q || root == p) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if (left != null && right != null) {
                return root;
            } else if (left != null) {
                return left;
            } else if (right != null) {
                return right;
            }
            return null;
        }

        //执行耗时:11 ms,击败了10.52% 的Java用户 内存消耗:39.8 MB,击败了35.78% 的Java用户
        public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
            ArrayDeque<TreeNode> pParent = new ArrayDeque<>();
            ArrayDeque<TreeNode> qParent = new ArrayDeque<>();
            findParent(qParent,root,q);
            findParent(pParent,root,p);
            TreeNode res = root;
            while (!qParent.isEmpty() || !pParent.isEmpty()) {
                if(qParent.peek() == pParent.peek()){
                    res = qParent.peek();
                    qParent.poll();
                    pParent.poll();
                }else {
                    break;
                }
            }
            return res;
        }
        public boolean findParent(ArrayDeque<TreeNode> queue,TreeNode root,TreeNode x){
            if (root == null) {
                return false;
            }
            if (root == x) {
                queue.push(x);
                return true;
            }
            if(findParent(queue,root.left,x) || findParent(queue,root.right,x)){
                queue.push(root);
                return true;
            }else {
                return false;
            }
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