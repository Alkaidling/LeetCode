package leetcode.editor.cn;

//剑指 Offer 26、树的子结构
class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
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
        //执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:40.2 MB,击败了41.07% 的Java用户
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }else {
                return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
            }
        }
        public boolean dfs(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            } else if (A == null || A.val != B.val) {
                return false;
            }else {
                return dfs(A.left,B.left) && dfs(A.right,B.right);
            }
        }

        //执行耗时:2 ms,击败了7.62% 的Java用户 内存消耗:39.9 MB,击败了86.63% 的Java用户
        public boolean isSubStructure0(TreeNode A, TreeNode B) {
            if (B == null) {
                return false;
            }else {
                return dfs(A,B,B);
            }
        }
        public boolean dfs(TreeNode A, TreeNode B,TreeNode bRoot) {
            if (B == null) {
                return true;
            }else if (A == null) {
                return false;
            }else if (A.val == B.val) {
                return (dfs(A.left, B.left, B) && dfs(A.right, B.right,B)) || dfs(A.left,B,B) || dfs(A.right,B,B);
            }else {
                if(!B.equals(bRoot)){
                    return false;
                }
                return dfs(A.left,B,B) || dfs(A.right,B,B);
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