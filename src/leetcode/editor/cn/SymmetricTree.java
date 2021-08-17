package leetcode.editor.cn;

import java.util.*;

//Java：101、对称二叉树
class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(2);
        root.right = rootRight;
        root.left = rootLeft;
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        rootLeft.left = leftLeft;
        rootLeft.right = leftRight;
        TreeNode RightLeft = new TreeNode(4);
        TreeNode RightRight = new TreeNode(3);
        rootRight.left = RightLeft;
        rootRight.right = RightRight;

        boolean symmetric = solution.isSymmetric(root);
        //boolean b = solution.structSymmetric(root.left, root.right);
        //System.out.println(b);
        System.out.println(symmetric);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //迭代⭐
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    public boolean check1(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


    //递归
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //一个向左移，一个向右移。保证镜像对称
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }



/*
    //深度优先搜索、先序遍历比较每个元素
    List<Integer> arr = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {

        boolean structSymmetric = this.structSymmetric(root.left, root.right);
        if(!structSymmetric)
            return false;

        List<Integer> list = this.inorderTraversal(root);
        int len = list.size()-1;
        int i = 0;
        while (len > i){
            if(list.get(len--) != list.get(i++))
                return false;
        }
        return true;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root.left != null)
            inorderTraversal(root.left);
        arr.add(root.val);
        if(root.right != null)
            inorderTraversal(root.right);
        return arr;
    }

    //判断结构是否对称
    public boolean structSymmetric(TreeNode p,TreeNode q){
        if(p == null && q == null)
            return true;
        else if(p == null && q != null)
            return false;
        else if(p != null && q == null)
            return false;
        else if(p != null && q != null){
            boolean left = structSymmetric(p.left, q.right);
            boolean right = structSymmetric(p.left, q.right);
            if (left && right)
                return true;
            else
                return false;
        }
        else
            return false;
    }

*/

}
//leetcode submit region end(Prohibit modification and deletion)
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}