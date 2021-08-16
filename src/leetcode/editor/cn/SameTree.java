package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：100、相同的树
class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();

        boolean left = false;
        boolean right = false;
        if (!left || !right){
            System.out.println("false");;
        }
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

    //深度优先搜索、先序遍历比较每个元素
    List<Integer> arr1 = new ArrayList<>();
    List<Integer> arr2 = new ArrayList<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null && q != null)
            return false;
        else if(p != null && q == null)
            return false;
        else if(p != null && q != null){
            arr1.add(p.val);
            arr2.add(q.val);
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            if (!left || !right){
                return false;
            }
            if(arr1.equals(arr2)){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  public class TreeNode {
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