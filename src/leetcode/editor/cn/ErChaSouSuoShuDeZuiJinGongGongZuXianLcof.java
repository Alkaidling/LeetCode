package leetcode.editor.cn;


import java.util.ArrayDeque;

//剑指 Offer 68 - I、二叉搜索树的最近公共祖先
class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
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

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode res = root;
            while (true) {
                if (res.val > p.val && res.val > q.val) {
                    res = res.left;
                } else if (res.val < p.val && res.val < q.val) {
                    res = res.right;
                }else {
                    break;
                }
            }
            return res;
        }

        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            ArrayDeque<TreeNode> qParent = new ArrayDeque<>();
            ArrayDeque<TreeNode> pParent = new ArrayDeque<>();
            dfs(qParent,root,q);
            dfs(pParent,root,p);
            TreeNode res = root;
            while (!qParent.isEmpty() || !pParent.isEmpty()) {
                if (qParent.peek() == pParent.peek()) {
                    qParent.poll();
                    res = pParent.poll();
                } else {
                    break;
                }
            }
            return res;
        }

        //求x的所有祖先
        public boolean dfs(ArrayDeque<TreeNode> queue, TreeNode root, TreeNode x) {
            if (root == null) {
                return false;
            }
            if (root == x) {
                queue.push(root);
                return true;
            }
            if (dfs(queue, root.left, x) || dfs(queue, root.right, x)) {
                queue.push(root);
                return true;
            }else {
                return false;
            }
        }


        //执行耗时:6 ms,击败了61.93% 的Java用户 内存消耗:39.1 MB,击败了26.81% 的Java用户
        //找出p、q的全部祖先
        public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
            ArrayDeque<TreeNode> pParent = new ArrayDeque<>();
            ArrayDeque<TreeNode> qParent = new ArrayDeque<>();
            TreeNode temp = root;
            while (temp != null) {
                int val = temp.val;
                pParent.offer(temp);
                if (val > p.val) {
                    temp = temp.left;
                } else if (val < p.val) {
                    temp = temp.right;
                } else {
                    break;
                }
            }
            temp = root;
            while (temp != null) {
                int val = temp.val;
                qParent.offer(temp);
                if (val > q.val) {
                    temp = temp.left;
                } else if (val < q.val) {
                    temp = temp.right;
                } else {
                    break;
                }
            }
            TreeNode res = root;
            while (!qParent.isEmpty() || !pParent.isEmpty()) {
                if (qParent.peek() == pParent.peek()) {
                    qParent.poll();
                    res = pParent.poll();
                } else {
                    break;
                }
            }
            return res;
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