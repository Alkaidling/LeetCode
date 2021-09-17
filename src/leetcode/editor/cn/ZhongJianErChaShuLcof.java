package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

//Java：剑指 Offer 07、重建二叉树
class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        //int[] preorder = {3,9,20,15,7};
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        //int[] inorder = {9,3,15,20,7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};

        TreeNode treeNode = solution.buildTree(preorder, inorder);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //递归
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int n = preorder.length;
        HashMap<Integer, Integer> inOrderMap = new HashMap<>(); // 节点值 -> inorder中的位置
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inOrderMap, 0, 0, n);
    }

    // preStart：先序数组中的开始位置，inStart：中序数组中的开始位置，size：这棵树的节点个数
    // 返回这棵树的根节点
    private TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> inOrderMap,
                               int preStart, int inStart, int size) {
        if (size <= 0) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndexInOrder = inOrderMap.get(root.val); // 根节点在中序数组中的位置，进而可确定左子树size和右子树size
        int leftSize = rootIndexInOrder - inStart, rightSize = size - leftSize - 1;

        root.left = buildTree(preorder, inOrderMap, preStart+1, inStart, leftSize);
        root.right = buildTree(preorder, inOrderMap, preStart + 1 + leftSize, rootIndexInOrder+1, rightSize);
        return root;
    }


    //迭代
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            //前序遍历，从根节点root开始，只要有左子节点，就一直会往左下方走，直到最左下角。
            //而中序遍历，是从最左下角往上（示例中的4-5-8-9-3），如果碰到节点有右子节点，则会转向（示例中的8-10）。
            //因此，代码中的if块是用前序数组一直构建左子树，如果碰到了inorder[inorderIndex]，表示到了左下角，
            //这时就需要往上走并处理右子树，也就是while代码块。
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    //递归分别求左子树和右子树	    执行耗时:13 ms,击败了7.52% 的Java用户    内存消耗:59.5 MB,击败了12.36% 的Java用户
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            if(preorder[i] > Integer.MIN_VALUE){
                root = new TreeNode(preorder[i]);//根节点
                preorder[i] = Integer.MIN_VALUE;
                break;
            }
        }
        if(root == null){
            return new TreeNode(-1);
        }
        //每次递归都要找根节点在中序遍历中的位置，效率低。考虑使用哈希表快速地定位根节点key=inorder[i],value=i，只需遍历一次中序数组即可。
        int i = 0;
        for (; i < inorder.length; i++) {
            if(inorder[i] == root.val){
                break;
            }
        }
        int[] leftInorder = new int[i];  //构建左子树
        for (int j = 0; j < i; j++) {
            leftInorder[j] = inorder[j];
        }
        int[] rightInorder = new int[inorder.length - i - 1]; //构建右子树
        for (int j = 0; j < rightInorder.length; j++) {
            rightInorder[j] = inorder[j+i+1];
        }
        if(leftInorder.length != 0){
            root.left = buildTree(preorder,leftInorder);
        }
        if(rightInorder.length != 0){
            root.right = buildTree(preorder,rightInorder);
        }
        if(leftInorder.length == 0 && leftInorder.length == 0){
            return root;
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
}