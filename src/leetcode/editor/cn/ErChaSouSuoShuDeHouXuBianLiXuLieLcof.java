package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;

//剑指 Offer 33、二叉搜索树的后序遍历序列
class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean verifyPostorder(int[] postorder) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int root = Integer.MAX_VALUE;
            for (int i = postorder.length - 1; i >= 0; i--) {
                if (postorder[i] > root) {
                    return false;
                }
                while (!stack.isEmpty() && stack.peek() > postorder[i]){
                    root = stack.pop();
                }
                stack.push(postorder[i]);
            }
            return true;
        }

        public boolean verifyPostorder1(int[] postorder) {
            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] postorder, int i, int j) {
            if (i >= j) {
                return true;
            }
            int p = i;
            while (postorder[p] < postorder[j]) {
                p++;
            }
            int m = p;  //此时m为右子树的第一个元素
            while (postorder[p] > postorder[j]) {
                p++;
            }
            return p == j && dfs(postorder, i, m - 1) && dfs(postorder, m, j - 1);
        }


        //执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:35.9 MB,击败了30.38% 的Java用户
        public boolean verifyPostorder0(int[] postorder) {
            if (postorder.length == 0) {
                return true;
            }
            int n = postorder.length;
            int root = postorder[n - 1];
            int leftSize = 0;
            for (int i = 0; i < n; i++) {
                if (postorder[i] < root) {
                    leftSize++;
                } else {
                    break;
                }
            }
            int[] left = new int[leftSize];  //左子树后序遍历
            for (int i = 0; i < leftSize; i++) {
                left[i] = postorder[i];
            }
            int[] right = new int[n - leftSize - 1];  //右子树后序遍历
            for (int i = 0; i < right.length; i++) {
                if (postorder[i + leftSize] < root) {
                    return false;
                }
                right[i] = postorder[i + leftSize];
            }
            //递归左右子树
            return verifyPostorder(left) && verifyPostorder(right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}