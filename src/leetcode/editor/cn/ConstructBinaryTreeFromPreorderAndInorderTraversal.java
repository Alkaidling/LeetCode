package leetcode.editor.cn;

import java.util.*;

//105、从前序与中序遍历序列构造二叉树
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] p = {3};
        int[] i = {3};
        TreeNode treeNode = solution.buildTree(p, i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Integer> indexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            indexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return dfs(preorder,0,0,inorder.length);
        }
        /**
         * @Description:
         * @param preorder 先序遍历数组
         * @param preIndex 子树先序遍历的起点下标
         * @param inoIndex 子树中序遍历的起点下标
         * @param count    树中节点数量
         * @return: {@link TreeNode}
         * @Author: Alkaid
         * @Date: 2021/12/23 14:57
         **/
        private TreeNode dfs(int[] preorder, int preIndex, int inoIndex, int count) {
            if (count == 0) {
                return null;
            }
            TreeNode head = new TreeNode(preorder[preIndex]);
            int root = indexMap.get(preorder[preIndex]);  //中序遍历中根节点的下标
            int leftCount = root - inoIndex;              //左子树节点数量
            int rightCount = count - 1 - leftCount;       //右子树节点数量
            TreeNode leftNode = dfs(preorder, preIndex + 1, inoIndex, leftCount);
            TreeNode rightNode = dfs(preorder, preIndex + 1 + leftCount, root + 1, rightCount);
            head.left = leftNode;
            head.right = rightNode;
            return head;
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