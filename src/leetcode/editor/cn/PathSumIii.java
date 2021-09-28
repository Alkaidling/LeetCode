package leetcode.editor.cn;

import java.util.*;

//437、路径总和 III
class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode rootLeft = new TreeNode(6);
        TreeNode rootRight = new TreeNode(8, new TreeNode(8), new TreeNode(2,null,new TreeNode(-2)));
        TreeNode root = new TreeNode(-8, rootLeft, rootRight);
        //TreeNode root = new TreeNode(3,new TreeNode(3),new TreeNode(3));
        int i = solution.pathSum(root, -2);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        //前缀和的递归回溯
        public int pathSum1(TreeNode root, int sum) {
            // key是前缀和, value是大小为key的前缀和出现的次数
            Map<Integer, Integer> prefixSumCount = new HashMap<>();
            // 前缀和为0的一条路径
            prefixSumCount.put(0, 1);
            // 前缀和的递归回溯思路
            return recursionPathSum(root, prefixSumCount, sum, 0);
        }

        /**
         * 前缀和的递归回溯思路
         * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
         * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
         * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
         * @param node 树节点
         * @param prefixSumCount 前缀和Map
         * @param target 目标值
         * @param currSum 当前路径和
         * @return 满足题意的解
         */
        private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
            // 1.递归终止条件
            if (node == null) {
                return 0;
            }
            // 2.本层要做的事情
            int res = 0;
            // 当前路径上的和
            currSum += node.val;

            //---核心代码
            // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
            // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
            // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
            res += prefixSumCount.getOrDefault(currSum - target, 0);
            // 更新路径上当前节点前缀和的个数
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
            //---核心代码

            // 3.进入下一层
            res += recursionPathSum(node.left, prefixSumCount, target, currSum);
            res += recursionPathSum(node.right, prefixSumCount, target, currSum);

            // 4.回到本层，恢复状态，去除当前节点的前缀和数量
            //由于我们只能统计往下的路径，但是树的遍历会同时搜索两个方向的子树。
            // 因此我们应当在搜索完以某个节点为根的左右子树之后，应当回溯地将路径总和从哈希表中删除，防止统计到跨越两个方向的路径。
            prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
            return res;
        }

        // 双重递归  时间O(n²) 空间O(n)
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            int ret = dfs(root,targetSum);
            ret += pathSum(root.left,targetSum);
            ret += pathSum(root.right,targetSum);
            return ret;
        }

        private int dfs(TreeNode root, int targetSum) {
            int ret = 0;
            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += dfs(root.left,targetSum - val);
            ret += dfs(root.right,targetSum - val);
            return ret;
        }

        //前缀和
        //public int pathSum(TreeNode root, int targetSum) {
        //    if (root == null) {
        //        return 0;
        //    }
        //    int num = 0;
        //    num = process(root, 0, targetSum);
        //    num += pathSum(root.left,targetSum);
        //    num += pathSum(root.right,targetSum);
        //    return num;
        //}
        //private int process(TreeNode root, int sum, int targetSum) {
        //    if (root == null) {
        //        return 0;
        //    }
        //
        //    int num = 0;
        //
        //    //不要root节点
        //    if (sum == 0) {
        //        int num2 = process(root.left, 0, targetSum) + process(root.right, 0, targetSum);
        //        num += num2;
        //    }
        //
        //    //要root结点
        //    sum += root.val;
        //    if (sum == targetSum) {
        //        num++;
        //    }
        //    int num1 =  process(root.left, sum, targetSum) + process(root.right, sum, targetSum);
        //    num += num1;
        //
        //    return num;
        //}
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